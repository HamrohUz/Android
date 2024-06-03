package uz.hamroh.store

import android.content.Context
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
        @ApplicationContext context: Context
    ): StoreRepository {
        return Store(context)
    }
}
