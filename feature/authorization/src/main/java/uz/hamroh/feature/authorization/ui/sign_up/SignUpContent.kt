package uz.hamroh.feature.authorization.ui.sign_up

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uz.hamroh.feature.authorization.R
import uz.hamroh.feature.authorization.ui.reset_password.RestoreEffect
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.components.CustomSnackbar
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohSmallText
import uz.hamroh.ui.components.RoundCheckboxWithText


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpContent(state: SignUpState, onEffect: (SignUpEffect) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            Image(
                painter = painterResource(uz.hamroh.ui.R.drawable.ic_chevron_left),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        onEffect(SignUpEffect.OnNavigateBack)
                    },
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.size(20.dp))
            HamrohHeaderText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                text = stringResource(R.string.signup_header),
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.size(30.dp))
            HamrohOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    HamrohDescriptionText(
                        text = stringResource(id = R.string.signup_email_hint),
                        textAlign = TextAlign.Left
                    )
                },
                value = state.email.value,
                onValueChange = { onEffect(SignUpEffect.OnEmailChange(it)) },
                supportingText = {
                    HamrohSmallText(text = stringResource(id = state.email.acceptance.resId))
                }
            )
            HamrohOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                placeholder = {
                    HamrohDescriptionText(
                        text = stringResource(id = R.string.signup_password_hint),
                        textAlign = TextAlign.Left
                    )
                },
                value = state.password.value,
                onValueChange = { onEffect(SignUpEffect.OnPasswordChange(it)) },
                visualTransformation = PasswordVisualTransformation(),
                supportingText = {
                    HamrohSmallText(text = stringResource(id = state.password.acceptance.resId))
                }
            )
            Spacer(modifier = Modifier.size(10.dp))
            RoundCheckboxWithText(
                state.isCheckedPolicy,
                text = stringResource(id = R.string.signup_accept_confidentiality_politics)
            ) { onEffect(SignUpEffect.OnRoundCheckBoxChanged) }
            Spacer(modifier = Modifier.size(30.dp))

            HamrohFilledButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onEffect(SignUpEffect.OnNavigateToLogin) },
                enabled = state.email.isNotEmptyAccepted && state.password.isNotEmptyAccepted && state.isCheckedPolicy
            ) {
                HamrohButtonText(text = stringResource(R.string.signup_create_account))
            }
            Spacer(modifier = Modifier.size(40.dp))
            HamrohDescriptionText(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = stringResource(R.string.signup_with_google),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(20.dp))
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
                    ) {
                        onEffect(SignUpEffect.OnNavigateToGoogleAuth)
                    },
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
                            onEffect(SignUpEffect.OnAccountExist)
                        },
                    text = stringResource(id = R.string.signup_already_registered)
                )
            }
            LaunchedEffect(key1 = state) {
                if (state.error.isNotEmpty()) {
                    scope.launch {
                        snackBarHostState.showSnackbar(state.error)
                        onEffect(SignUpEffect.OnSnackBarDisplayed)
                    }
                }
            }
        }
    }
}