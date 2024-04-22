package uz.hamroh.navigation

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen

class AppCoordinator(private val router: Router) : Coordinator {
    override fun navigateTo(screen: Screen) {
        router.navigateTo(screen)
    }

    override fun replace(screen: Screen) {
        router.replaceScreen(screen)
    }
    override fun backToPreviousScreen() {
        router.exit()
    }

    override fun newRootScreen(screen: Screen) {
        router.newRootScreen(screen)
    }
}