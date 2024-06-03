package uz.hamroh.feature.authorization.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.feature.authorization.ui.auth_selection.AuthSelectionViewModel
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : ComposeFragment() {
    private val viewModel by viewModels<LoginViewModel>()
    @Composable
    override fun ComposeContent() {
        val state = viewModel.state.collectAsState()
        LoginContent(loginState = state.value) {
            when(it) {
                LoginEffect.NavigateToPrevious -> viewModel.onPreviousScreen()
                LoginEffect.NavigateToNext -> viewModel.onNextScreen()
                LoginEffect.NavigateToGoogleAuth -> {}
                LoginEffect.NavigateToSignUp -> viewModel.onNavigateToSignUp()
                LoginEffect.NavigateToRestorePassword -> viewModel.onNavigateToRestorePassword()
                LoginEffect.OnSnackBarDisplayed -> viewModel.onSnackBarDisplayed()
                is LoginEffect.OnEmailValueChange -> viewModel.onEmailPasswordChange(it.value)
                is LoginEffect.OnPasswordValueChange -> viewModel.onPasswordChange(it.value)
            }
        }
    }

}