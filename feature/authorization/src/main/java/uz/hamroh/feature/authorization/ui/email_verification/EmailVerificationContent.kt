package uz.hamroh.feature.authorization.ui.email_verification

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uz.hamroh.feature.authorization.R
import uz.hamroh.feature.authorization.ui.reset_password.RestoreEffect
import uz.hamroh.feature.authorization.ui.sign_up.SignUpEffect
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.components.CustomSnackbar
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText
import uz.hamroh.ui.components.OutlinedOtpTextField

@Composable
fun EmailVerificationContent(
    state: EmailVerificationState,
    onEffect: (EmailVerificationEffect) -> Unit
) {
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
                .padding(it)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
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
                        onEffect(EmailVerificationEffect.OnNavigateToPrevious)
                    },
                contentScale = ContentScale.FillBounds
            )
            HamrohHeaderText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 20.dp),
                text = stringResource(R.string.email_verification_header),
                textAlign = TextAlign.Left
            )
            HamrohDescriptionText(
                modifier = Modifier.padding(vertical = 10.dp),
                text = stringResource(R.string.email_verification_description, state.email)
            )
            OutlinedOtpTextField(
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 4.dp),
                value = state.code,
                onValueChange = { onEffect(EmailVerificationEffect.OnOtpCodeChange(it)) })
            HamrohFilledButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                onClick = { onEffect(EmailVerificationEffect.OnConfirm) },
                enabled = state.isOtpFilled
            ) {
                HamrohButtonText(text = stringResource(R.string.email_verification_confirm))
            }
        }
        LaunchedEffect(key1 = state) {
            if(state.error.isNotEmpty()) {
                scope.launch {
                    snackBarHostState.showSnackbar(state.error)
                    onEffect(EmailVerificationEffect.OnSnackBarDisplayed)
                }
            }
        }
    }
}