package uz.hamroh.feature.authorization.data

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import uz.hamroh.feature.authorization.data.model.request.AuthRequest
import uz.hamroh.feature.authorization.data.model.request.EmailRequest
import uz.hamroh.feature.authorization.data.model.request.RecoverPasswordRequest
import uz.hamroh.feature.authorization.data.model.response.AuthResponse
import uz.hamroh.feature.authorization.data.model.response.TokenResponse
import uz.hamroh.feature.authorization.data.model.response.VerificationResponse
import uz.hamroh.network.BaseResponse

interface AuthApi {
    @POST("/api/auth/register")
    suspend fun register(@Body registerRequest: AuthRequest): BaseResponse

    @POST("/api/auth/login")
    suspend fun login(@Body loginRequest: AuthRequest): AuthResponse

    @POST("/api/auth/send-verification-code")
    suspend fun sendVerificationCode(@Body otpCodeRequest: EmailRequest): VerificationResponse

    @POST("/api/auth/verify-email")
    suspend fun verifyEmail(@Body emailVerificationRequest: EmailRequest): TokenResponse

    @POST("/api/auth/reset-password")
    suspend fun resetPassword(@Body authRequest: RecoverPasswordRequest): TokenResponse

    @POST("/api/auth/check-account-existence")
    suspend fun checkAccount(@Body emailRequest: EmailRequest): BaseResponse

    @POST("/api/auth/check-token")
    suspend fun checkToken(@Header("Authorization") token: String) : TokenResponse
    @POST("/api/auth/google-auth")
    suspend fun authorizeWithGoogle(@Header("Authorization") token: String): AuthResponse
}