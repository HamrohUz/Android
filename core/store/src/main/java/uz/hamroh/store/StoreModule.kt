package uz.hamroh.store

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TripModule {
    @Provides
    @Singleton
    fun provideStoreRepository(
        @ApplicationContext context: Context,
        sharedPreferences: SharedPreferences
    ): StoreRepository {
        return Store(context, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences( @ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("Store", Context.MODE_PRIVATE)
    }
}
