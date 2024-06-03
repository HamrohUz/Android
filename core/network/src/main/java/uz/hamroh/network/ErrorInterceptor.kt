package uz.hamroh.network

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException
import java.net.HttpURLConnection

class ErrorInterceptor(
    private val moshi: Moshi,
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val response = chain.proceed(original)
        val body = response.body?.string() ?: ""
        val adapter = moshi.adapter(BaseResponse::class.java).lenient()
        val baseResponse = adapter.fromJson(body)
        return try {
            if(baseResponse?.success == true) {
                response
            } else {
                throw BackendException(
                    code = baseResponse?.statusCode ?: 0,
                    message = baseResponse?.message ?: ""
                )
            }
        } catch (e: Exception) {
            return Response.Builder()
                .request(original)
                .protocol(Protocol.HTTP_1_1)
                .code(baseResponse?.statusCode ?: HttpURLConnection.HTTP_INTERNAL_ERROR)
                .message(baseResponse?.message ?: "")
                .body("{${e}}".toResponseBody(null)).build()
        }
    }
}