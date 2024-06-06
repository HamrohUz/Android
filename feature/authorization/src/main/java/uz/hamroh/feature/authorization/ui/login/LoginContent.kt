package uz.hamroh.feature.authorization.ui.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uz.hamroh.feature.authorization.R
import uz.hamroh.ui.components.CustomSnackbar
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohSmallText
import uz.hamroh.ui.util.ValidationResultType


@Composable
fun LoginContent(loginState: LoginState, onLoginEffect: (LoginEffect) -> Unit) {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState,
                snackbar = { CustomSnackbar(it) }
            )
        },
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(it),
        ) {
            Image(
                painter = painterResource(uz.hamroh.ui.R.drawable.ic_chevron_left),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 30.dp, bottom = 20.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        onLoginEffect(LoginEffect.NavigateToPrevious)
                    },
                contentScale = ContentScale.FillBounds
            )
            HamrohHeaderText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 40.dp),
                text = stringResource(R.string.login_header_and_button),
                textAlign = TextAlign.Left
            )
            HamrohOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    HamrohDescriptionText(
                        text = stringResource(id = R.string.signup_email_hint),
                        textAlign = TextAlign.Left
                    )
                },
                value = loginState.email.value,
                onValueChange = { onLoginEffect(LoginEffect.OnEmailValueChange(it)) },
                isError = loginState.email.acceptance != ValidationResultType.ACCEPTED,
                supportingText = { HamrohSmallText(text = stringResource(id = loginState.email.acceptance.resId)) },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
            )
            HamrohOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 5.dp),
                placeholder = {
                    HamrohDescriptionText(
                        text = stringResource(id = R.string.signup_password_hint),
                        textAlign = TextAlign.Left
                    )
                },
                supportingText = {
                    HamrohSmallText(text = stringResource(id = loginState.password.acceptance.resId))
                },
                visualTransformation = PasswordVisualTransformation(),
                value = loginState.password.value,
                isError = loginState.password.acceptance != ValidationResultType.ACCEPTED,
                onValueChange = { onLoginEffect(LoginEffect.OnPasswordValueChange(it)) }
            )
            HamrohSmallText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        onLoginEffect(LoginEffect.NavigateToRestorePassword)
                    },
                text = stringResource(id = R.string.login_forgot_password),
                textAlign = TextAlign.Right
            )
            HamrohFilledButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onLoginEffect(LoginEffect.NavigateToNext) },
                enabled = loginState.email.isNotEmptyAccepted && loginState.password.isNotEmptyAccepted
            ) {
                HamrohButtonText(text = stringResource(R.string.login_header_and_button))
            }
            HamrohDescriptionText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 20.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(R.string.signup_with_google),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(uz.hamroh.ui.R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { onLoginEffect(LoginEffect.NavigateToGoogleAuth) },
                contentScale = ContentScale.FillBounds
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                HamrohDescriptionText(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            onLoginEffect(LoginEffect.NavigateToSignUp)
                        },
                    text = stringResource(id = R.string.login_redirect_to_signup)
                )
            }
            LaunchedEffect(key1 = loginState) {
                if (loginState.error.isNotEmpty()) {
                    scope.launch {
                        snackBarHostState.showSnackbar(loginState.error)
                        onLoginEffect(LoginEffect.OnSnackBarDisplayed)
                    }
                }
            }
        }
    }
}