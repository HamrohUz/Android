package uz.hamroh.feature.authorization.ui.auth_status

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.navigation.TripNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class AuthStatusFragment(private val title: String = "", private val message: String=""): ComposeFragment() {
    @Inject lateinit var tripNavigation: TripNavigation
    @Composable
    override fun ComposeContent() = AuthStatusContent(title, message, tripNavigation)

}