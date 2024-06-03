package uz.hamroh.network

sealed class ErrorEntity {
    data object Network : ErrorEntity()
    data object NotFound : ErrorEntity()
    data object AccessDenied : ErrorEntity()
    data object UnAuthorized: ErrorEntity()
    data object ServiceUnavailable : ErrorEntity()
    data class Unknown(val error: Throwable) : ErrorEntity()
}