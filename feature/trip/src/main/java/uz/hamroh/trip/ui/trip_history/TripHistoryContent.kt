package uz.hamroh.trip.ui.trip_history

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uz.hamroh.ui.components.HamrohHeaderText

@Composable
fun TripHistoryContent(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        HamrohHeaderText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 60.dp),
            text = "Мои поездки",
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(150.dp))
        HamrohHeaderText(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "У вас пока\nнет объявлений"
        )
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(uz.hamroh.trip.R.drawable.ic_car_unpluged24),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}
