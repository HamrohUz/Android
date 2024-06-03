package uz.hamroh.main

import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.hamroh.coroutines.launchIO
import uz.hamroh.feature.authorization.ui.AuthScreens
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.TripNavigation
import uz.hamroh.store.StoreRepository
import uz.hamroh.trip.ui.TripDestinations
import uz.hamroh.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appCoordinator: AppCoordinator,
    private val navigatorHolder: NavigatorHolder,
    private val storeRepository: StoreRepository,
) : BaseViewModel<MainState, MainEffect>(MainState()) {

    fun getNavigationHolder() = navigatorHolder
    fun getCurrentNavigationState() {
        viewModelScope.launch {
            if (storeRepository.getToken().isEmpty()) appCoordinator.replace(AuthScreens.AuthSelection())
            else appCoordinator.replace(TripDestinations.Main())
        }
    }
}