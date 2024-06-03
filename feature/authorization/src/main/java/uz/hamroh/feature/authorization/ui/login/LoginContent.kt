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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.hamroh.feature.authorization.R
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohSmallText

@Composable
fun LoginContent(authNavigation: AuthNavigation) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.chevron_left),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Start).padding(top = 30.dp, bottom = 20.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    authNavigation.navigateBack()
                },
            contentScale = ContentScale.FillBounds
        )
        HamrohHeaderText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp , bottom = 60.dp),
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
            value = email,
            onValueChange = { email = it }
        )
        HamrohOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 25.dp),
            placeholder = {
                HamrohDescriptionText(
                    text = stringResource(id = R.string.signup_password_hint),
                    textAlign = TextAlign.Left
                )
            },
            supportingText = {
                HamrohSmallText(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    text = stringResource(id = R.string.login_forgot_password),
                    textAlign = TextAlign.Right
                )
            },
            value = password,
            onValueChange = { password = it }
        )
        HamrohFilledButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { authNavigation.navigateToEmailVerification() }
        ) {
            HamrohButtonText(text = stringResource(R.string.login_header_and_button))
        }
        HamrohDescriptionText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=40.dp, bottom = 20.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.signup_with_google),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(R.drawable.google_icon),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    authNavigation.navigateBack()
                },
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp) // Optional padding
        ) {
            HamrohDescriptionText(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = stringResource(id = R.string.login_redirect_to_signup)
            )
        }
    }
}