package uz.hamroh.profile.ui.car

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohTitleLargeText
import uz.hamroh.ui.components.RoundCheckboxWithText

@Composable
fun CarInformationContent() {
    MyScreenContent()
}

@Composable
fun MyScreenContent() {
    var carModel by remember { mutableStateOf("Volkswagen Touareg") }
    var carColor by remember { mutableStateOf("Black") }
    var carPlate by remember { mutableStateOf("0777OO77") }
    var saveCar by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Действие при нажатии назад */ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Назад"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            HamrohTitleLargeText(text = "Транспорт")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Автомобиль",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth()
        )
        HamrohOutlinedTextField(
            value = carModel,
            onValueChange = { carModel = it },
            textStyle = TextStyle(fontSize = 16.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Цвет",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                HamrohOutlinedTextField(
                    value = carColor,
                    onValueChange = { carColor = it },
                    textStyle = TextStyle(fontSize = 16.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Гос. Знак",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                HamrohOutlinedTextField(
                    value = carPlate,
                    onValueChange = { carPlate = it },
                    textStyle = TextStyle(fontSize = 16.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        RoundCheckboxWithText(isChecked = saveCar, text = "Выбирать машину по умолчанию", onChecked = { saveCar = saveCar.not()})

        Spacer(modifier = Modifier.weight(1f))

        HamrohFilledButton(
            onClick = { /* Действие при нажатии */ },
        ) {
            HamrohButtonText(
                modifier = Modifier.fillMaxWidth(),
                text = "Сохранить машину",
            )
        }
    }
}