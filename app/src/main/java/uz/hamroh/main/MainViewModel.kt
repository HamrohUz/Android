package uz.hamroh.main

import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.hamroh.coroutines.launchIO
import uz.hamroh.feature.authorization.data.model.response.TokenResponse
import uz.hamroh.feature.authorization.data.repository.AuthRepository
import uz.hamroh.feature.authorization.ui.AuthScreens
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.TripNavigation
import uz.hamroh.network.ResponseWrapper
import uz.hamroh.store.StoreRepository
import uz.hamroh.home.ui.TripDestinations
import uz.hamroh.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appCoordinator: AppCoordinator,
    private val navigatorHolder: NavigatorHolder,
    private val authRepository: AuthRepository,
    private val storeRepository: StoreRepository,
) : BaseViewModel<MainState, MainEffect>(MainState()) {

    fun getNavigationHolder() = navigatorHolder
    fun getCurrentNavigationState() {
        viewModelScope.launchIO {
            val token = storeRepository.getToken()
            if (token?.isEmpty() == true) {
                delay(2000L)
                appCoordinator.replace(AuthScreens.AuthSelection())
            } else {
                delay(2000L)
                handleResponse(authRepository.checkToken(token ?: ""))
            }
            setState { copy(isLoaderVisible = false) }
        }
    }

    private fun handleResponse(response: ResponseWrapper<TokenResponse>){
        when(response) {
            is ResponseWrapper.Success -> {
                storeRepository.setToken(response.data.data.token)
                appCoordinator.replace(TripDestinations.Main())
            }
            is ResponseWrapper.Error -> appCoordinator.replace(AuthScreens.AuthSelection())
        }
    }

    fun checkIsFirstLaunch() {
        viewModelScope.launch {
            if (storeRepository.isFirstLaunch()) {
                getCurrentNavigationState()
                storeRepository.setFirstLaunchState()
            }
        }
    }
}