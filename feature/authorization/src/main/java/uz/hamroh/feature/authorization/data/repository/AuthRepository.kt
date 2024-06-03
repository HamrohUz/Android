package uz.hamroh.feature.authorization.data.repository

import uz.hamroh.feature.authorization.data.model.request.AuthRequest
import uz.hamroh.feature.authorization.data.model.request.EmailRequest
import uz.hamroh.feature.authorization.data.model.request.ResetPasswordRequest
import uz.hamroh.feature.authorization.data.model.response.VerificationResponse
import uz.hamroh.network.BaseResponse
import uz.hamroh.network.Result

interface AuthRepository {
    suspend fun register(registerRequest: AuthRequest)
    suspend fun login(loginRequest: AuthRequest)
    suspend fun sendVerificationCode(otpCodeRequest: EmailRequest): VerificationResponse
    suspend fun verifyEmail(emailVerificationRequest: EmailRequest)
    suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest)
}