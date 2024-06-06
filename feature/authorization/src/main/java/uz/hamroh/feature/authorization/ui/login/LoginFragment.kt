package uz.hamroh.feature.authorization.ui.login

import android.content.IntentSender
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.hilt.android.AndroidEntryPoint
import uz.hamroh.feature.authorization.BuildConfig
import uz.hamroh.feature.authorization.di.AuthModule
import uz.hamroh.ui.base.ComposeFragment
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : ComposeFragment() {
    private val viewModel by viewModels<LoginViewModel>()
    @Inject lateinit var oneTapClient: SignInClient
    @Inject
    @AuthModule.SignIn
    lateinit var signInRequest: BeginSignInRequest
    @Inject
    @AuthModule.SignUp
    lateinit var signUpRequest: BeginSignInRequest

    private var googleOneTapSignInLauncher: ActivityResultLauncher<IntentSenderRequest>?  = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        googleOneTapSignInLauncher = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result: ActivityResult ->
            result.data?.let {
                try {
                    val credential = oneTapClient.getSignInCredentialFromIntent(it)
                    val googleToken = credential.googleIdToken
                    val oneTapUsername = credential.id
                    val oneTapPassword = credential.password
                    when {
                        !googleToken.isNullOrEmpty() -> {
                            handleGoogleSignInSuccess(googleToken)
                        }
                        oneTapPassword != null && oneTapUsername.isNotEmpty() && oneTapPassword.isNotEmpty() -> {
                            handlePasswordSignInSuccess(oneTapUsername, oneTapPassword)
                        }
                        else -> {
                        }
                    }
                } catch (_: Exception) {

                }
            }
        }
    }

    @Composable
    override fun ComposeContent() {
        val state = viewModel.state.collectAsState()
        LoginContent(loginState = state.value) {
            when(it) {
                LoginEffect.NavigateToPrevious -> viewModel.onPreviousScreen()
                LoginEffect.NavigateToNext -> viewModel.onNextScreen()
                LoginEffect.NavigateToGoogleAuth -> authorizeWithGoogle()
                LoginEffect.NavigateToSignUp -> viewModel.onNavigateToSignUp()
                LoginEffect.NavigateToRestorePassword -> viewModel.onNavigateToRestorePassword()
                LoginEffect.OnSnackBarDisplayed -> viewModel.onSnackBarDisplayed()
                is LoginEffect.OnEmailValueChange -> viewModel.onEmailChange(it.value)
                is LoginEffect.OnPasswordValueChange -> viewModel.onPasswordChange(it.value)
            }
        }
    }


    private fun authorizeWithGoogle() {
        oneTapClient.beginSignIn(signInRequest)
            .addOnSuccessListener { result ->
                try {
                    googleOneTapSignInLauncher?.launch(
                        IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                    )
                } catch (_: IntentSender.SendIntentException) { }
            }.addOnFailureListener {
                oneTapClient.beginSignIn(signUpRequest).addOnSuccessListener { result ->
                    try {
                        googleOneTapSignInLauncher?.launch(
                            IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                        )
                    } catch (_: IntentSender.SendIntentException) { }
                }
            }
    }

    private fun handleGoogleSignInSuccess(googleToken: String) {
        viewModel.onGoogleSignIn(googleToken)
    }

    private fun handlePasswordSignInSuccess(username: String, password: String) {
        // Handle the successful password sign-in
        // For example, authenticate with your backend server using the username and password
    }




}