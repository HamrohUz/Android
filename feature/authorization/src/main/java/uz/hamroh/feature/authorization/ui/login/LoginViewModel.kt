package uz.hamroh.feature.authorization.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.hamroh.coroutines.launchIO
import uz.hamroh.feature.authorization.data.model.response.AuthResponse
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.TripNavigation
import uz.hamroh.network.ErrorEntity
import uz.hamroh.network.ResponseWrapper
import uz.hamroh.store.StoreRepository
import uz.hamroh.ui.base.BaseViewModel
import uz.hamroh.ui.util.Validator
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authNavigation: AuthNavigation,
    private val tripNavigation: TripNavigation,
    private val storeRepository: StoreRepository,
    private val authRepository: AuthRepository,
) : BaseViewModel<LoginState, LoginEffect>(LoginState()) {
    fun onNavigateToRestorePassword() {
        authNavigation.navigateToRestorePassword()
    }

    fun onEmailChange(email: String) {
        setState { copy(email = Validator.validateEmail(email)) }
    }

    fun onPasswordChange(value: String) {
        setState { copy(password = Validator.validatePassword(value)) }
    }

    fun onNavigateToSignUp() {
        authNavigation.navigateToSignUp()
    }

    fun onPreviousScreen() {
        authNavigation.navigateBack()
    }

    fun onSnackBarDisplayed() {
        setState { copy(error = "") }
    }

    fun onNextScreen() {
        viewModelScope.launch {
            val response = authRepository.login(state.value.email.value, state.value.password.value)
            handleResult(response)
        }
    }

    fun onGoogleSignIn(token: String) {
        viewModelScope.launch {
            handleResult(authRepository.authorizeWithGoogle(token))
        }
    }

    private fun handleResult(result: ResponseWrapper<AuthResponse>) {
        when (result) {
            is ResponseWrapper.Success -> {
                val token = result.data.data.token
                val email = result.data.data.user.email
                val name = result.data.data.user.name
                viewModelScope.launchIO {
                    storeRepository.setToken(token)
                    storeRepository.setUserEmail(email)
                    storeRepository.setName(name)
                }
                tripNavigation.navigateToMain()
            }

            is ResponseWrapper.Error -> {
                when (result.error) {
                    is ErrorEntity.IsNotAcceptable -> {
                        viewModelScope.launch {
                            authNavigation.navigateToEmailVerification(
                                state.value.email.value,
                                state.value.password.value
                            )
                        }
                    }

                    is ErrorEntity.Unauthorized -> setState { copy(error = (result.error as ErrorEntity.Unauthorized).message) }
                    is ErrorEntity.NotFound -> setState { copy(error = (result.error as ErrorEntity.NotFound).message) }
                    else -> setState { copy(error = "Сервис не доступен") }
                }
            }
        }
    }
}