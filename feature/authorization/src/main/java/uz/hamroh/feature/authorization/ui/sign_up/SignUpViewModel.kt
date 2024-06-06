package uz.hamroh.feature.authorization.ui.sign_up

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.hamroh.feature.authorization.data.AuthApi
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.RouteIntent
import uz.hamroh.network.BaseResponse
import uz.hamroh.network.ErrorEntity
import uz.hamroh.network.ResponseWrapper
import uz.hamroh.ui.base.BaseViewModel
import uz.hamroh.ui.util.Validator
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authNavigation: AuthNavigation,
    private val authRepository: AuthRepository,
):BaseViewModel<SignUpState, SignUpEffect>(SignUpState()) {

    fun onEmailChange(email: String) {
        setState { copy(email = Validator.validateEmail(email)) }
    }

    fun onPasswordChange(value: String) {
        setState { copy(password = Validator.validatePassword(value)) }
    }

    fun onNavigateToLogin() {
        viewModelScope.launch {
            val response = authRepository.register(state.value.email.value, state.value.password.value)
            handleResult(response)
        }
    }

    private fun handleResult(response: ResponseWrapper<BaseResponse>) {
        when(response) {
            is ResponseWrapper.Success -> {
                authNavigation.navigateToLogin()
            }
            is ResponseWrapper.Error -> {
                when (response.error) {
                    is ErrorEntity.Conflict -> setState { copy(error = (response.error as ErrorEntity.Conflict).message) }
                    else -> setState { copy(error = "Cервис не доступен") }
                }
            }
        }
    }

    fun onNavigateToPrevious() {
        authNavigation.navigateBack()
    }

    fun onAccountExists() {
        authNavigation.navigateToLogin()
    }

    fun onPolicyClicked() {
        setState { copy(isCheckedPolicy = state.value.isCheckedPolicy.not()) }
    }

    fun onSnackBarDisplayed() {
        setState { copy(error = "") }
    }

}