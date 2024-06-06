package uz.hamroh.feature.authorization.data.repository

import uz.hamroh.feature.authorization.data.AuthApi
import uz.hamroh.feature.authorization.data.model.request.AuthRequest
import uz.hamroh.feature.authorization.data.model.request.EmailRequest
import uz.hamroh.feature.authorization.data.model.request.RecoverPasswordRequest
import uz.hamroh.feature.authorization.data.model.response.AuthResponse
import uz.hamroh.feature.authorization.data.model.response.TokenResponse
import uz.hamroh.feature.authorization.data.model.response.VerificationResponse
import uz.hamroh.network.BaseResponse
import uz.hamroh.network.ResponseWrapper
import uz.hamroh.network.executeApiCall
import javax.inject.Inject

class AuthImpl @Inject constructor(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun register(email: String, password: String): ResponseWrapper<BaseResponse>{
        return executeApiCall({ authApi.register(AuthRequest(email, password)) }) { it as BaseResponse }
    }

    override suspend fun login(email: String, password: String): ResponseWrapper<AuthResponse> {
        return executeApiCall({ authApi.login(AuthRequest(email, password)) }) { it as AuthResponse}
    }

    override suspend fun sendVerificationCode(email: String): ResponseWrapper<VerificationResponse> {
        return executeApiCall({ authApi.sendVerificationCode(EmailRequest(email)) }) { it as VerificationResponse}
    }

    override suspend fun verifyEmail(email: String): ResponseWrapper<TokenResponse> {
        return executeApiCall({ authApi.verifyEmail(EmailRequest(email)) }) { it as TokenResponse}
    }

    override suspend fun resetPassword(email: String, password: String): ResponseWrapper<TokenResponse> {
        return executeApiCall({ authApi.resetPassword(RecoverPasswordRequest(email, password)) }) { it as TokenResponse}
    }

    override suspend fun checkAccount(email: String): ResponseWrapper<BaseResponse> {
        return executeApiCall({ authApi.checkAccount(EmailRequest(email)) }) { it as BaseResponse}
    }

    override suspend fun checkToken(token: String): ResponseWrapper<TokenResponse> {
        return executeApiCall({ authApi.checkToken(token) }) { it as TokenResponse}
    }

    override suspend fun authorizeWithGoogle(token: String): ResponseWrapper<AuthResponse> {
        return executeApiCall({ authApi.authorizeWithGoogle(token) }) { it as AuthResponse}
    }
}