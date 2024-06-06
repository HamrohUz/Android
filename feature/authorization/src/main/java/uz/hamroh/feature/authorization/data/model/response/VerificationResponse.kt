package uz.hamroh.feature.authorization.data.model.response

import com.squareup.moshi.Json
import uz.hamroh.network.BaseResponse

data class VerificationResponse(
    @Json(name = "statusCode") override val statusCode: Int,
    @Json(name = "status") override val status: String,
    @Json(name = "success") override val success: Boolean,
    @Json(name = "message") override val message: String,
    @Json(name = "data") override val data: OtpCodeData
) : BaseResponse(statusCode, status, success, message, data)
data class OtpCodeData(@Json(name = "otp") val otp: String)