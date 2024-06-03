package uz.hamroh.feature.authorization.data.model.request

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class ResetPasswordRequest(
    @Json(name = "email") val email:String,
    @Json(name = "password") val password: String,
)
