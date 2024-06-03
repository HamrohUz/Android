package uz.hamroh.trip.ui.main

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject


@AndroidEntryPoint
class TripFragment : ComposeFragment() {

    @Inject lateinit var authNavigation: AuthNavigation
    @Composable
    override fun ComposeContent() = TripContent()

}