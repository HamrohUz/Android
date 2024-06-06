package uz.hamroh.feature.authorization.data.model.response

import com.squareup.moshi.Json
import uz.hamroh.network.BaseResponse

data class User(
    @Json(name = "name") val name: String = "",
    @Json(name = "email") val email: String
)

data class LoginData(
    @Json(name = "user") val user: User,
    @Json(name = "token") val token: String
)

data class AuthResponse(
    @Json(name = "statusCode") override val statusCode: Int,
    @Json(name = "status") override val status: String,
    @Json(name = "success") override val success: Boolean,
    @Json(name = "message") override val message: String,
    @Json(name = "data") override val data: LoginData
) : BaseResponse(statusCode, status, success, message, data)