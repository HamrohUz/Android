package uz.hamroh.network

data class BaseResponseDto(
    val success: Boolean,
    val errorEntity: ErrorEntity?
)
