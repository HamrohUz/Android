package uz.hamroh.navigation

import com.github.terrakok.cicerone.Screen

interface Coordinator {
    fun navigateTo(screen: Screen)
    fun replace(screen: Screen)
    fun backToPreviousScreen()
    fun newRootScreen(screen: Screen)
}