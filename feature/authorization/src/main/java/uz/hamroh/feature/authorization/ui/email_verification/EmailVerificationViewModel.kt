package uz.hamroh.feature.authorization.ui.email_verification

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.hamroh.feature.authorization.data.model.response.TokenResponse
import uz.hamroh.feature.authorization.data.model.response.VerificationResponse
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.RouteIntent
import uz.hamroh.network.ErrorEntity
import uz.hamroh.network.ResponseWrapper
import uz.hamroh.store.StoreRepository
import uz.hamroh.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class EmailVerificationViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val authNavigation: AuthNavigation,
    private val storeRepository: StoreRepository,
) : BaseViewModel<EmailVerificationState, EmailVerificationEffect>(EmailVerificationState()) {

    fun sendVerificationCode(email: String) {
        setState { copy(email = email) }
        viewModelScope.launch {
            handleEmailVerification(authRepository.sendVerificationCode(email))
        }
    }

    fun onNavigateToPrevious() {
        authNavigation.navigateBack()
    }

    fun onOtpCodeChange(code: String) {
        setState {
            copy(
                code = code,
                isOtpFilled = code.length == OTP_LENGTH
            )
        }
    }

    fun onSnackBarDisplayed() {
        setState { copy(error = "") }
    }

    fun onNavigateToAuthStatus(email: String, password: String, routeIntent: RouteIntent) {
        viewModelScope.launch {
            val isOtpCorrect = state.value.expectedOtp == state.value.code
            if (isOtpCorrect.not()) {
                setState { copy(error = "Неверный код") }
                return@launch
            }
            when (routeIntent) {
                RouteIntent.RecoverPassword -> {
                    val resetPasswordResponse = authRepository.resetPassword(email, password)
                    handleOtpResponse(resetPasswordResponse)
                    storeRepository.setUserEmail(email)
                    authNavigation.navigateToAuthStatus("Ваш пароль был успешно изменен", "Теперь вы можете пользоваться нашим приложением!")
                }

                RouteIntent.VerifyEmail -> {
                    val verifyResponse = authRepository.verifyEmail(email)
                    handleOtpResponse(verifyResponse)
                    authNavigation.navigateToAuthStatus("Аккаунт создан", "Теперь вы можете пользоваться нашим приложением!")
                }
            }
        }
    }


    private fun handleOtpResponse(response: ResponseWrapper<TokenResponse>) {
        when (response) {
            is ResponseWrapper.Success -> {
                storeRepository.setToken(response.data.data.token)
            }
            is ResponseWrapper.Error -> {
                when (response.error) {
                    is ErrorEntity.NotFound -> setState { copy(error = (response.error as ErrorEntity.NotFound).message) }
                    is ErrorEntity.BadRequest -> setState { copy(error = (response.error as ErrorEntity.BadRequest).message) }
                    else -> setState { copy(error = "Сервис не доступен") }
                }
            }
        }
    }

    private fun handleEmailVerification(response: ResponseWrapper<VerificationResponse>) {
        when (response) {
            is ResponseWrapper.Success -> {
                setState { copy(expectedOtp = response.data.data.otp) }
            }
            is ResponseWrapper.Error -> {}
        }
    }

    companion object {
        private const val OTP_LENGTH = 4
    }
}