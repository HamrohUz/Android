package uz.hamroh.home.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohSmallText
import uz.hamroh.ui.components.HamrohTitleLargeText


@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        var user by remember { mutableStateOf("") }
        HamrohTitleLargeText(
            text = "Найти поездку",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        ToggleSwitch {
            user = it
        }
        if (user == "Я попутчик") {
            PassengerScreen()
        } else {
            DriverScreen()
        }
    }
}

@Composable
fun DriverScreen() {
}

@Composable
fun PassengerScreen() {
    var location by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LocationInput(
            label = "Откуда",
            icon = uz.hamroh.ui.R.drawable.ic_location_on_24,
            trailingIcon = uz.hamroh.ui.R.drawable.ic_close
        )
        LocationInput(
            label = "Куда",
            icon = uz.hamroh.ui.R.drawable.ic_location_on_24,
            trailingIcon = uz.hamroh.ui.R.drawable.ic_close
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HamrohOutlinedTextField(
                modifier = Modifier.weight(1f),
                value = location,
                label = { HamrohSmallText(text = "Дата") },
                onValueChange = { location = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number,
                ),
            )
            Spacer(modifier = Modifier.width(8.dp))
            HamrohOutlinedTextField(
                modifier = Modifier.weight(1f),
                value = date,
                label = { HamrohSmallText(text = "Кол-во человек") },
                onValueChange = { date = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.NumberPassword
                ),
            )
        }

        HamrohFilledButton(modifier = Modifier.fillMaxWidth(), onClick = { }) {
            HamrohButtonText(text = "Поиск предложений")
        }
    }
}

@Composable
fun ToggleSwitch(onToggleSwitched: (String) -> Unit) {
    var selected by remember { mutableStateOf("Я попутчик") }
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .background(Color.LightGray, shape = RoundedCornerShape(24))
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    if (selected == "Я попутчик") Color.White else Color.Transparent,
                    shape = RoundedCornerShape(24)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    selected = "Я попутчик"
                    onToggleSwitched(selected)
                }
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Я попутчик",
                fontSize = 16.sp,
                color = if (selected == "Я попутчик") Color.Black else Color.Gray
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    if (selected == "Я водитель") Color.White else Color.Transparent,
                    shape = RoundedCornerShape(24)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    selected = "Я водитель"
                    onToggleSwitched(selected)
                }
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Я водитель",
                fontSize = 16.sp,
                color = if (selected == "Я водитель") Color.Black else Color.Gray
            )
        }
    }
}

@Composable
fun LocationInput(label: String, icon: Int, trailingIcon: Int) {
    var location by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(modifier = Modifier, text = label, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        HamrohOutlinedTextField(
            value = location,
            onValueChange = { location = it },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text,
            ),
        )
    }
}
