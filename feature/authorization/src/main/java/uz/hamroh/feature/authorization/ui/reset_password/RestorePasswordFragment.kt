package uz.hamroh.feature.authorization.ui.reset_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.feature.authorization.ui.login.LoginViewModel
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class RestorePasswordFragment : ComposeFragment() {
    private val viewModel by viewModels<RestoreViewModel>()

    @Composable
    override fun ComposeContent() {
        val state = viewModel.state.collectAsState()
        RestorePasswordContent(state.value) {
            when(it) {
                RestoreEffect.OnNavigateToOtp -> {viewModel.onNavigateToOtp()}
                RestoreEffect.OnNavigateToPrevious -> {viewModel.onNavigateToPrevious()}
                is RestoreEffect.OnPasswordChange -> { viewModel.onPasswordChange(it.password)}
                is RestoreEffect.OnEmailChange -> {viewModel.onEmailPasswordChange(it.email)}
            }
        }
    }
}