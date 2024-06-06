package uz.hamroh.home.ui.compose_navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.hamroh.home.ui.chats.ChatContent
import uz.hamroh.home.ui.home.HomeContent
import uz.hamroh.home.ui.profile.Profile
import uz.hamroh.home.ui.profile.ProfileViewModel
import uz.hamroh.home.ui.trip_history.TripHistoryContent
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun AppNavigator(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.PROFILE,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tween(700)
            )
        }
    ) {
        composable(MainScreen.HOME) { HomeContent() }
        composable(MainScreen.TRIP_HISTORY) { TripHistoryContent() }
        composable(MainScreen.CHATS) { ChatContent() }
        composable(MainScreen.PROFILE) { Profile() }
    }
}