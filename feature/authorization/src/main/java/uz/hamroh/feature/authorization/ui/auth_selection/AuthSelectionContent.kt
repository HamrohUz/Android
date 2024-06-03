package uz.hamroh.feature.authorization.ui.auth_selection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.hamroh.feature.authorization.R
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText
import uz.hamroh.ui.components.HamrohOutlinedButton

@Composable
fun AuthSelectionContent(authNavigation: AuthNavigation) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(50.dp))
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .padding(horizontal = 16.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.size(30.dp))
        HamrohHeaderText(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(horizontal = 16.dp),
            text = stringResource(R.string.auth_selection_header_create_account)
        )
        HamrohDescriptionText(text = stringResource(R.string.auth_selection_header_description))
        Spacer(modifier = Modifier.size(45.dp))
        HamrohFilledButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { authNavigation.navigateToLogin() }
        ) {
            HamrohButtonText(text = stringResource(R.string.auth_selection_button_login))
        }
        Spacer(modifier = Modifier.size(10.dp))
        HamrohOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { authNavigation.navigateToSignUp() }) {
            HamrohButtonText(text = stringResource(R.string.auth_selection_button_signup))
        }
        Spacer(modifier = Modifier.size(10.dp))
        Image(
            painter = painterResource(R.drawable.city),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
    }
}