package uz.hamroh.home.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import uz.hamroh.home.ui.compose_navigation.AppNavigator
import uz.hamroh.home.ui.compose_navigation.BottomNavigationBar
import uz.hamroh.ui.theme.HamrohTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TripContent() {
    val navController = rememberNavController()
    HamrohTheme {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    AppNavigator(navController = navController)
                }
            },
        )
    }
}