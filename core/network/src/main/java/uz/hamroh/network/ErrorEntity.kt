package uz.hamroh.network

sealed class ErrorEntity {

    data class BadRequest(val message: String): ErrorEntity()
    data class NotFound(val message: String) : ErrorEntity()
    data class AccessDenied(val message: String) : ErrorEntity()
    data class InternalServerError(val message: String) : ErrorEntity()
    data class Unauthorized(val message: String): ErrorEntity()
    data class Conflict(val message: String): ErrorEntity()
    data class IsNotAcceptable(val message: String): ErrorEntity()
    data class Unknown(val error: Throwable) : ErrorEntity() {
        val message: String get() = error.message ?: "Unknown error"
    }
}


fun mapError(statusCode: Int, message: String = ""): ErrorEntity {
    return when (statusCode) {
        400 -> ErrorEntity.BadRequest(message)
        401 -> ErrorEntity.Unauthorized(message)
        403 -> ErrorEntity.AccessDenied(message)
        406 -> ErrorEntity.IsNotAcceptable(message)
        404 -> ErrorEntity.NotFound(message)
        409 -> ErrorEntity.Conflict(message)
        500 -> ErrorEntity.InternalServerError(message)
        else -> ErrorEntity.Unknown(Exception())
    }
}