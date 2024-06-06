package uz.hamroh.profile.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.ProfileNavigation
import uz.hamroh.profile.destination.ProfileNavigationImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {
    @Singleton
    @Provides
    fun provideProfile(appCoordinator: AppCoordinator): ProfileNavigation =
        ProfileNavigationImpl(appCoordinator)
}