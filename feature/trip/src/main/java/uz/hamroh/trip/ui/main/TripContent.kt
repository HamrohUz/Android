package uz.hamroh.trip.ui.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import uz.hamroh.trip.ui.compose_navigation.AppNavigator
import uz.hamroh.trip.ui.compose_navigation.BottomNavigationBar
import uz.hamroh.ui.theme.HamrohTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TripContent() {
    val navController = rememberNavController()
    HamrohTheme {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) }
        ) {
            AppNavigator(navController)
        }
    }
}