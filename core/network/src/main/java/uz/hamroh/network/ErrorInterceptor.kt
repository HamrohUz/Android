package uz.hamroh.network

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import uz.hamroh.store.StoreRepository
import java.io.IOException
import java.net.HttpURLConnection

class ErrorInterceptor(
    private val moshi: Moshi,
    private val storeRepository: StoreRepository,
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val token = storeRepository.getToken()
        val newRequest = if (!token.isNullOrEmpty()) original.newBuilder()
            .header("Authorization", "$token")
            .build() else null
        val response = chain.proceed(original)
        val body = response.peekBody(Long.MAX_VALUE).string()
        val adapter = moshi.adapter(BaseResponse::class.java).lenient()
        val baseResponse = adapter.fromJson(body)
        return try {
            if (baseResponse?.success == true) {
                if(newRequest != null) chain.proceed(newRequest)
                else chain.proceed(original)
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