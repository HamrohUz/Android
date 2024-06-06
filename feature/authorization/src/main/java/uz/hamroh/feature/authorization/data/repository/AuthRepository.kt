package uz.hamroh.feature.authorization.data.repository

import uz.hamroh.feature.authorization.data.model.response.AuthResponse
import uz.hamroh.feature.authorization.data.model.response.TokenResponse
import uz.hamroh.feature.authorization.data.model.response.VerificationResponse
import uz.hamroh.network.BaseResponse
import uz.hamroh.network.ResponseWrapper

interface AuthRepository {
    suspend fun register(email: String, password: String): ResponseWrapper<BaseResponse>
    suspend fun login(email: String, password: String): ResponseWrapper<AuthResponse>
    suspend fun sendVerificationCode(email: String): ResponseWrapper<VerificationResponse>
    suspend fun verifyEmail(email: String): ResponseWrapper<TokenResponse>
    suspend fun resetPassword(email: String, password: String): ResponseWrapper<TokenResponse>
    suspend fun checkAccount(email: String) : ResponseWrapper<BaseResponse>
    suspend fun checkToken(token: String): ResponseWrapper<TokenResponse>
    suspend fun authorizeWithGoogle(token: String): ResponseWrapper<AuthResponse>
}