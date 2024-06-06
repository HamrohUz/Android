package uz.hamroh.home.ui.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.hamroh.trip.R
import uz.hamroh.ui.components.HamrohDescriptionText
import uz.hamroh.ui.components.HamrohHeaderText

@Composable
fun ChatContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(uz.hamroh.ui.R.drawable.ic_car_unpluged24),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        HamrohHeaderText(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "Функция чата в разработке!"
        )
        HamrohDescriptionText(text = "Мы работаем над этим и скоро предоставим вам возможность общаться в чатах")
    }
}