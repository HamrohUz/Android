package uz.hamroh.feature.authorization.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import uz.hamroh.feature.authorization.data.model.request.AuthRequest
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.BaseViewModel
import uz.hamroh.ui.util.Validator
import java.net.HttpURLConnection
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authNavigation: AuthNavigation,
    private val authRepository: AuthRepository,
) : BaseViewModel<LoginState, LoginEffect>(LoginState()) {
    fun onNavigateToRestorePassword() {
        authNavigation.navigateToRestorePassword()
    }

    fun onEmailPasswordChange(email: String) {
        viewModelScope.launch {
            setState {
                copy(
                    email = Validator.validateEmail(email)
                )
            }
        }
    }

    fun onPasswordChange(value: String) {
        viewModelScope.launch {
            setState {
                copy(
                    password = Validator.validatePassword(value)
                )
            }
        }
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
            try {
                authRepository.login(
                    AuthRequest(
                        email = state.value.email.value,
                        password = state.value.password.value
                    )
                )
            } catch (throwable: Throwable) {
                if(throwable is HttpException){
                    val error = throwable.message?.split(" ", limit = 3)?.getOrNull(2) ?: "Unknown error"
                    when(throwable.code()){
                        HttpURLConnection.HTTP_NOT_FOUND -> setState { copy(error = error) }
                        HttpURLConnection.HTTP_NOT_ACCEPTABLE -> authNavigation.navigateToEmailVerification(state.value.email.value)
                        HttpURLConnection.HTTP_INTERNAL_ERROR -> setState { copy(error = error) }
                    }
                }
            }
        }
    }
}