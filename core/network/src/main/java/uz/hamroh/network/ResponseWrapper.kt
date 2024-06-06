package uz.hamroh.network

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val data: T) : ResponseWrapper<T>()
    data class Error(val error: ErrorEntity) : ResponseWrapper<Nothing>()
}