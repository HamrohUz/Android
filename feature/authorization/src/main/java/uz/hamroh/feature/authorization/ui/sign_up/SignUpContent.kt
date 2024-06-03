package uz.hamroh.feature.authorization.ui.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
fun SignUpContent(authNavigation: AuthNavigation) {
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
        Spacer(modifier = Modifier.size(30.dp))
        Image(
            painter = painterResource(uz.hamroh.ui.R.drawable.ic_chevron_left),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Start)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    authNavigation.navigateBack()
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
            value = email,
            onValueChange = { email = it }
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
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.size(10.dp))
        RoundCheckboxWithText()
        Spacer(modifier = Modifier.size(30.dp))

        HamrohFilledButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { authNavigation.navigateToLogin() }
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
                    authNavigation.navigateBack()
                },
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp) // Optional padding
        ) {
            HamrohDescriptionText(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = stringResource(id = R.string.signup_already_registered)
            )
        }
    }
}

@Composable
fun RoundCheckboxWithText() {
    val isChecked = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier.fillMaxWidth().padding(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(
                    color = if (isChecked.value) Color.Blue else MaterialTheme.colorScheme.surfaceTint,
                    shape = CircleShape
                )
                .border(
                    width = 2.dp,
                    color = if (isChecked.value) Color.Blue else MaterialTheme.colorScheme.surfaceTint,
                    shape = CircleShape
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { isChecked.value = !isChecked.value },
            contentAlignment = Alignment.Center
        ) {
            if (isChecked.value) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Checked",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        HamrohSmallText(text = stringResource(id = R.string.signup_accept_confidentiality_politics))
    }
}