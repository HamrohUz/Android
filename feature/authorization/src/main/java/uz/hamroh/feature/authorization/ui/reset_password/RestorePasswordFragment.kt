package uz.hamroh.feature.authorization.ui.reset_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.ui.base.ComposeFragment

@AndroidEntryPoint
class RestorePasswordFragment : ComposeFragment() {
    private val viewModel by viewModels<RestoreViewModel>()

    @Composable
    override fun ComposeContent() {
        val state = viewModel.state.collectAsState()
        RestorePasswordContent(state.value) {
            when(it) {
                RestoreEffect.OnNavigateToOtp -> viewModel.onNavigateToOtp()
                RestoreEffect.OnNavigateToPrevious -> viewModel.onNavigateToPrevious()
                RestoreEffect.OnSnackBarDisplayed -> viewModel.onSnackBarDisplayed()
                is RestoreEffect.OnPasswordChange -> viewModel.onPasswordChange(it.password)
                is RestoreEffect.OnEmailChange -> viewModel.onEmailChange(it.email)
            }
        }
    }
}