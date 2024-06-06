package uz.hamroh.profile.ui.contact_information

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.hamroh.profile.R
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohTitleLargeText
import uz.hamroh.ui.components.RoundCheckboxWithText
import uz.hamroh.ui.components.Section

@Composable
fun ContactInformationContent() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var isDisabled by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { HamrohTitleLargeText("Контактная информация") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 0.dp
            )
        },
        backgroundColor = Color(0xFFF5F5F5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(it)
        ) {
            Section(isDisabledSectionTitle = true) {
                HamrohTitleLargeText("Имя")
                HamrohOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    value = firstName,
                    onValueChange = { firstName = it })
                Spacer(modifier = Modifier.height(16.dp))
                HamrohTitleLargeText("Фамилия")
                HamrohOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    value = lastName,
                    onValueChange = { lastName = it })
                Spacer(modifier = Modifier.height(16.dp))
                HamrohTitleLargeText("Дата Рождения")
                HamrohOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    value = birthDate,
                    onValueChange = { birthDate = it })
                Spacer(modifier = Modifier.height(16.dp))
                HamrohTitleLargeText("Номер телефона")
                HamrohOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it })
                Spacer(modifier = Modifier.height(16.dp))
                RoundCheckboxWithText(
                    isChecked = isDisabled,
                    text = stringResource(id = R.string.disability)
                ) {
                    isDisabled = isDisabled.not()
                }
            }
            HamrohFilledButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                onClick = { }
            ) {
                HamrohButtonText(text = stringResource(R.string.save))
            }
        }
    }
}