package uz.hamroh.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofitInstance(@ApplicationContext context: Context): Retrofit =
        Retrofit.Builder().apply {
            baseUrl(BuildConfig.BACKEND_URL)
            client(
                OkHttpClient.Builder().apply {
                    if(BuildConfig.DEBUG) {
                        addInterceptor(
                            ChuckerInterceptor.Builder(context = context)
                                .collector(
                                    collector = ChuckerCollector(
                                        context = context,
                                        showNotification = true,
                                        retentionPeriod = RetentionManager.Period.ONE_WEEK
                                    )
                                )
                                .alwaysReadResponseBody(enable = true)
                                .build()
                        )
                    }
                }.build()
            )
            addConverterFactory(GsonConverterFactory.create())
        }.build()
}