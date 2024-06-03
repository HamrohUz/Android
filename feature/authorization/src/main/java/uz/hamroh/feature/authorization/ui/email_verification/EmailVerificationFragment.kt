package uz.hamroh.feature.authorization.ui.email_verification

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.RouteIntent
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class EmailVerificationFragment(private val email: String = "", private val routeIntent: RouteIntent) : ComposeFragment() {

    @Inject lateinit var authNavigation: AuthNavigation
    @Composable
    override fun ComposeContent() = EmailVerificationContent(authNavigation)

}