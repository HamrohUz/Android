package uz.hamroh.feature.authorization.data.model.request

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class EmailRequest(
    @Json(name = "email") val email: String
)
