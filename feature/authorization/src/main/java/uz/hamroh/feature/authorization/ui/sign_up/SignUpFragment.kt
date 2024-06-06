package uz.hamroh.feature.authorization.ui.sign_up

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.feature.authorization.ui.reset_password.RestoreViewModel
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : ComposeFragment() {
    private val viewModel by viewModels<SignUpViewModel>()

    @Composable
    override fun ComposeContent() {
        val state = viewModel.state.collectAsState()
        SignUpContent(state = state.value) {
            when (it) {
                SignUpEffect.OnNavigateToLogin -> viewModel.onNavigateToLogin()
                SignUpEffect.OnAccountExist -> viewModel.onAccountExists()
                SignUpEffect.OnNavigateToGoogleAuth -> {}
                SignUpEffect.OnNavigateBack -> viewModel.onNavigateToPrevious()
                SignUpEffect.OnSnackBarDisplayed -> viewModel.onSnackBarDisplayed()
                SignUpEffect.OnRoundCheckBoxChanged -> viewModel.onPolicyClicked()
                is SignUpEffect.OnEmailChange -> viewModel.onEmailChange(it.email)
                is SignUpEffect.OnPasswordChange -> viewModel.onPasswordChange(it.password)
            }
        }
    }

}