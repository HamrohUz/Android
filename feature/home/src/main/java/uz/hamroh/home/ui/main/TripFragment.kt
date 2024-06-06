package uz.hamroh.home.ui.main

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.home.ui.profile.ProfileViewModel
import uz.hamroh.ui.base.ComposeFragment


@AndroidEntryPoint
class TripFragment : ComposeFragment() {
    @Composable
    override fun ComposeContent() = TripContent()

}