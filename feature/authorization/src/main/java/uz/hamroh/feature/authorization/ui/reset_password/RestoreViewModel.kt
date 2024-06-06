package uz.hamroh.feature.authorization.ui.reset_password

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
class RestoreViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val authNavigation: AuthNavigation,
) : BaseViewModel<RestoreState, RestoreEffect>(RestoreState()) {

    fun onEmailChange(email: String) {
        setState { copy(email = Validator.validateEmail(email)) }
    }

    fun onPasswordChange(value: String) {
        setState { copy(password = Validator.validatePassword(value)) }
    }

    fun onNavigateToOtp() {
        viewModelScope.launch {
            val response = authRepository.checkAccount(state.value.email.value)
            handleResult(response)
        }
    }

    fun onSnackBarDisplayed() {
        setState { copy(error = "") }
    }

    private fun handleResult(result: ResponseWrapper<BaseResponse>) {
        when (result) {
            is ResponseWrapper.Success -> {
                authNavigation.navigateToEmailVerification(
                    state.value.email.value,
                    state.value.password.value,
                    RouteIntent.RecoverPassword
                )
            }
            is ResponseWrapper.Error -> {
                when (result.error) {
                    is ErrorEntity.NotFound -> setState { copy(error = (result.error as ErrorEntity.NotFound).message) }
                    else -> setState { copy(error = "Cервис не доступен") }
                }
            }
        }
    }

    fun onNavigateToPrevious() {
        authNavigation.navigateBack()
    }

}