package uz.hamroh.feature.authorization.ui.reset_password

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.hamroh.feature.authorization.data.AuthApi
import uz.hamroh.feature.authorization.data.model.request.EmailRequest
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.RouteIntent
import uz.hamroh.ui.base.BaseViewModel
import uz.hamroh.ui.util.Validator
import javax.inject.Inject

@HiltViewModel
class RestoreViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val authNavigation: AuthNavigation,
) : BaseViewModel<RestoreState, RestoreEffect>(RestoreState()) {

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

    fun onNavigateToOtp() {
        viewModelScope.launch {
            try {
                authRepository.sendVerificationCode(EmailRequest(state.value.email.value))
                authNavigation.navigateToEmailVerification(state.value.email.value, RouteIntent.RecoverPassword)
            } catch (throwable: Throwable) {
                Log.d("RESTORE_D", throwable.message.toString())
            }
        }
    }

    fun onNavigateToPrevious() {
        authNavigation.navigateBack()
    }

}