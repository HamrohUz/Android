package uz.hamroh.feature.authorization.data.model.request

import com.squareup.moshi.Json

data class RecoverPasswordRequest(
    @Json(name = "email") val email: String,
    @Json(name = "newPassword") val password: String,
)
