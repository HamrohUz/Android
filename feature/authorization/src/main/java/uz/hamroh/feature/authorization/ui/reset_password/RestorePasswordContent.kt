package uz.hamroh.feature.authorization.ui.reset_password

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import uz.hamroh.ui.components.CustomSnackbar
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohSmallText

@Composable
fun RestorePasswordContent(restoreState: RestoreState, onEffect: (RestoreEffect) -> Unit) {
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
                .padding(horizontal = 16.dp)
                .padding(it),
        ) {
            Image(
                painter = painterResource(uz.hamroh.ui.R.drawable.ic_chevron_left),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Start).padding(top = 30.dp, bottom = 20.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        onEffect(RestoreEffect.OnNavigateToPrevious)
                    },
                contentScale = ContentScale.FillBounds
            )
            HamrohHeaderText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 60.dp),
                text = stringResource(R.string.login_forgot_password),
                textAlign = TextAlign.Left
            )
            HamrohOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    HamrohDescriptionText(
                        text = stringResource(id = R.string.restore_password_email_input),
                        textAlign = TextAlign.Left
                    )
                },
                value = restoreState.email.value,
                onValueChange = { onEffect(RestoreEffect.OnEmailChange(it))},
                supportingText = {
                    HamrohSmallText(text = stringResource(id = restoreState.email.acceptance.resId))
                },
            )
            HamrohOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 25.dp),
                placeholder = {
                    HamrohDescriptionText(
                        text = stringResource(id = R.string.restore_password_password_input),
                        textAlign = TextAlign.Left
                    )
                },
                value = restoreState.password.value,
                onValueChange = { onEffect(RestoreEffect.OnPasswordChange(it)) },
                supportingText = {
                    HamrohSmallText(text = stringResource(id = restoreState.password.acceptance.resId))
                },
                visualTransformation = PasswordVisualTransformation()
            )
            HamrohFilledButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onEffect(RestoreEffect.OnNavigateToOtp) },
                enabled = restoreState.email.isNotEmptyAccepted && restoreState.password.isNotEmptyAccepted
            ) {
                HamrohButtonText(text = stringResource(R.string.restore_password_next_button))
            }
        }
        LaunchedEffect(key1 = restoreState) {
            if(restoreState.error.isNotEmpty()) {
                scope.launch {
                    snackBarHostState.showSnackbar(restoreState.error)
                    onEffect(RestoreEffect.OnSnackBarDisplayed)
                }
            }
        }
    }
}