package uz.hamroh.feature.authorization.data.repository

import uz.hamroh.feature.authorization.data.AuthApi
import uz.hamroh.feature.authorization.data.model.request.AuthRequest
import uz.hamroh.feature.authorization.data.model.request.EmailRequest
import uz.hamroh.feature.authorization.data.model.request.ResetPasswordRequest
import uz.hamroh.feature.authorization.data.model.response.VerificationResponse
import uz.hamroh.network.BaseResponse
import javax.inject.Inject

class AuthImpl @Inject constructor(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun register(registerRequest: AuthRequest) {
        authApi.register(registerRequest)
    }

    override suspend fun login(loginRequest: AuthRequest) {
        authApi.login(loginRequest)
    }

    override suspend fun sendVerificationCode(otpCodeRequest: EmailRequest): VerificationResponse {
        return authApi.sendVerificationCode(otpCodeRequest)
    }

    override suspend fun verifyEmail(emailVerificationRequest: EmailRequest) {
        authApi.verifyEmail(emailVerificationRequest)
    }

    override suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest) {
        authApi.resetPassword(resetPasswordRequest)
    }
}