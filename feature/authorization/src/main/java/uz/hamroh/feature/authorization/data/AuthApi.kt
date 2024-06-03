package uz.hamroh.feature.authorization.data

import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.hamroh.feature.authorization.data.model.request.AuthRequest
import uz.hamroh.feature.authorization.data.model.request.EmailRequest
import uz.hamroh.feature.authorization.data.model.request.ResetPasswordRequest
import uz.hamroh.feature.authorization.data.model.response.OtpCodeDto
import uz.hamroh.feature.authorization.data.model.response.VerificationResponse
import uz.hamroh.network.BaseResponse

interface AuthApi {
    @POST("/api/auth/register")
    suspend fun register(@Body registerRequest: AuthRequest)

    @POST("/api/auth/login")
    suspend fun login(@Body loginRequest: AuthRequest): BaseResponse

    @POST("/api/auth/send-verification-code")
    suspend fun sendVerificationCode(@Body otpCodeRequest: EmailRequest): VerificationResponse

    @POST("/api/auth/verify-email")
    suspend fun verifyEmail(@Body emailVerificationRequest: EmailRequest)

    @POST("/api/auth/reset-password")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest)
}