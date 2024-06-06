package uz.hamroh.network

import retrofit2.HttpException

suspend fun <T> executeApiCall(apiCall: suspend () -> BaseResponse, transform: (Any?) -> T): ResponseWrapper<T> {
    return try {
        val response = apiCall()
        if (response.success) {
            val data = if(response.data == null) BaseResponse() else response
            ResponseWrapper.Success(transform(data))
        } else {
            ResponseWrapper.Error(mapError(response.statusCode))
        }
    } catch (e: HttpException) {
        ResponseWrapper.Error(mapError(e.code(), e.message()))
    } catch (throwable: Throwable) {
        ResponseWrapper.Error(ErrorEntity.Unknown(throwable))
    }
}