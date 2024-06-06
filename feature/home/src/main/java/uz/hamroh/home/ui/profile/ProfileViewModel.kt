package uz.hamroh.home.ui.profile

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.hamroh.coroutines.launchIO
import uz.hamroh.navigation.ProfileNavigation
import uz.hamroh.store.StoreRepository
import uz.hamroh.home.ui.profile.ProfileEffect
import uz.hamroh.home.ui.profile.ProfileState
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileNavigation: ProfileNavigation,
    private val authNavigation: AuthNavigation,
    private val storeRepository: StoreRepository,
): BaseViewModel<ProfileState, ProfileEffect>(ProfileState()) {

    init {
        viewModelScope.launch {
            val email = storeRepository.getEmail()
            setState { copy(email = email) }
        }
    }

    fun onNavigateToContactInformation() {
        profileNavigation.navigateToContactInformation()
    }

    fun onNavigateToSecurity() {
        profileNavigation.navigateToSecurity()
    }

    fun onNavigateToPayment() {
        profileNavigation.navigateToPayment()
    }
    fun onNavigateToCars() {
        profileNavigation.navigateToCars()
    }

    fun onNavigateToDocuments() {
        profileNavigation.navigateToDocuments()
    }

    fun onLogout() {
        viewModelScope.launchIO {
            storeRepository.onLogout()
            authNavigation.replaceToLogin()
        }
    }
}