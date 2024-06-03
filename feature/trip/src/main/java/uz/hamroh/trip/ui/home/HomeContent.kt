package uz.hamroh.trip.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohHeaderText
import uz.hamroh.ui.components.HamrohOutlinedTextField

@Composable
fun HomeContent(navController: NavHostController) {
    var fromText by remember {
        mutableStateOf("Львовская, 1В (НИУ ВШЭ)")
    }
    var to by remember {
        mutableStateOf("Горьковское море")
    }
    var data by remember {
        mutableStateOf("23.04.2024")
    }
    var numberOfPeople by remember {
        mutableStateOf("1")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HamrohHeaderText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 30.dp),
            text = "Найти поездку",
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(50.dp))
        HamrohOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            value = fromText,
            onValueChange = { fromText = it },
            label = { HamrohButtonText(text = "Откуда") },
        )
        HamrohOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            value = to,
            onValueChange = { to = it },
            label = { HamrohButtonText("Куда") },
            trailingIcon = {
                IconButton(onClick = { /* Handle open map */ }) {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "Открыть карту")
                }
            }
        )
        HamrohOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            value = data,
            onValueChange = {data = it},
            label = { HamrohButtonText("Дата") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number,
            )
        )
        HamrohOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            value = numberOfPeople,
            onValueChange = {numberOfPeople = it},
            label = { HamrohButtonText("Кол-во людей") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.NumberPassword,
            )
        )
        HamrohFilledButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            onClick = { /* Handle search */ },
        ) {
            HamrohButtonText("Поиск предложений")
        }
    }
}
