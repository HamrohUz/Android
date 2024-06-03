package uz.hamroh.network

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: ErrorEntity) : Result<Nothing>()
}