package uz.hamroh.feature.authorization.ui.email_verification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.feature.authorization.ui.login.LoginViewModel
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.RouteIntent
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class EmailVerificationFragment(
    private val email: String = "",
    private val password: String,
    private val routeIntent: RouteIntent
) : ComposeFragment() {
    private val viewModel by viewModels<EmailVerificationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sendVerificationCode(email)
    }
    @Composable
    override fun ComposeContent() {
        val state = viewModel.state.collectAsState()
        EmailVerificationContent(state = state.value) {
            when(it) {
                EmailVerificationEffect.OnNavigateToPrevious -> viewModel.onNavigateToPrevious()
                EmailVerificationEffect.OnSnackBarDisplayed -> viewModel.onSnackBarDisplayed()
                EmailVerificationEffect.OnConfirm -> viewModel.onNavigateToAuthStatus(email, password, routeIntent)
                is EmailVerificationEffect.OnOtpCodeChange -> viewModel.onOtpCodeChange(it.text)
            }
        }
    }

}