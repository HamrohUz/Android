package uz.hamroh.feature.authorization.ui.auth_selection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.ui.base.ComposeFragment

@AndroidEntryPoint
class AuthSelectionFragment : ComposeFragment() {
    private val viewModel by viewModels<AuthSelectionViewModel>()

    @Composable
    override fun ComposeContent() {
        val state = viewModel.state.collectAsState()
        AuthSelectionContent(state = state.value) { authEffect ->
            when (authEffect) {
                AuthSelectionEffect.NavigateToLogin -> viewModel.onNavigateToLogin()
                AuthSelectionEffect.NavigateToSignUp -> viewModel.onNavigateToRegistration()
            }
        }
    }
}