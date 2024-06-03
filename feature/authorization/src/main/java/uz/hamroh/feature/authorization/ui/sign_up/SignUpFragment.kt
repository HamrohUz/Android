package uz.hamroh.feature.authorization.ui.sign_up

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : ComposeFragment() {
    @Inject lateinit var authNavigation: AuthNavigation
    @Composable
    override fun ComposeContent() = SignUpContent(authNavigation = authNavigation)

}