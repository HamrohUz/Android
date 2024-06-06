package uz.hamroh.network

import com.squareup.moshi.Json

open class BaseResponse(
    @Json(name = "statusCode") open val statusCode: Int = 0,
    @Json(name = "status") open val status: String = "",
    @Json(name = "success") open val success: Boolean = true,
    @Json(name = "message") open val message: String = "",
    @Json(name = "data") open val data: Any? = null
)
