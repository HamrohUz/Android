package uz.hamroh.feature.authorization.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.hamroh.feature.authorization.data.AuthApi
import uz.hamroh.feature.authorization.data.repository.AuthImpl
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.feature.authorization.ui.AuthNavigationImpl
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.AuthNavigation
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Singleton
    @Provides
    fun provideAuth(appCoordinator: AppCoordinator): AuthNavigation =
        AuthNavigationImpl(appCoordinator)

    @Singleton
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Singleton
    @Provides
    fun provideAuthRepository(authApi: AuthApi): AuthRepository = AuthImpl(authApi)
}
