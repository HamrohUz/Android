package uz.hamroh.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.TripNavigation
import uz.hamroh.home.ui.TripDestinations
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TripModule {

    @Singleton
    @Provides
    fun provideTripScreen(appCoordinator: AppCoordinator): TripNavigation {
        return TripNavigationImp(appCoordinator)
    }
}

class TripNavigationImp(private val appCoordinator: AppCoordinator): TripNavigation {
    override fun navigateToMain() {
        appCoordinator.replace(TripDestinations.Main())
    }
}