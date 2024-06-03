package uz.hamroh.network

import com.squareup.moshi.Json

open class BaseResponse(
    @Json(name = "timeStamp") open val timeStamp: String,
    @Json(name = "statusCode") open val statusCode: Int,
    @Json(name = "status") open val status: String,
    @Json(name = "success") open val success: Boolean?,
    @Json(name = "message") open val message: String,
)