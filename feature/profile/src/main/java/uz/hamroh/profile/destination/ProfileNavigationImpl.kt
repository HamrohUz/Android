package uz.hamroh.profile.destination

import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.ProfileNavigation

class ProfileNavigationImpl(private val appCoordinator: AppCoordinator): ProfileNavigation {
    override fun navigateToContactInformation() {
        appCoordinator.navigateTo(ProfileDestinations.ContactInformation())
    }

    override fun navigateToSecurity() {
        appCoordinator.navigateTo(ProfileDestinations.Security())
    }

    override fun navigateToPayment() {
        appCoordinator.navigateTo(ProfileDestinations.Payment())
    }

    override fun navigateToCars() {
        appCoordinator.navigateTo(ProfileDestinations.CarInformation())
    }

    override fun navigateToDocuments() {
        appCoordinator.navigateTo(ProfileDestinations.Documents())
    }
}