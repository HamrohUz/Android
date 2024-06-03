package uz.hamroh.feature.authorization.ui.auth_status

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.hamroh.feature.authorization.R
import uz.hamroh.navigation.TripNavigation
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText

@Preview(showBackground = true)
@Composable
private fun AuthStatusContentPreview() = AuthStatusContent(title = "Поздравляем", message = "Вы теперь можете зайти", tripNavigation = null )
@Composable
fun AuthStatusContent(title: String, message: String, tripNavigation: TripNavigation?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(uz.hamroh.ui.R.drawable.ic_stars),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        HamrohHeaderText(
            modifier = Modifier.padding(vertical = 15.dp),
            text = title
        )
        HamrohDescriptionText(text = message)
        Spacer(modifier = Modifier.size(30.dp))
        HamrohFilledButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { tripNavigation?.navigateToMain() }
        ) {
            HamrohButtonText(text = stringResource(R.string.auth_selection_button_login))
        }

    }
}