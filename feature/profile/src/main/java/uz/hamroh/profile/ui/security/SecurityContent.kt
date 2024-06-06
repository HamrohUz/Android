package uz.hamroh.profile.ui.security

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import uz.hamroh.profile.R
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohTitleLargeText
import uz.hamroh.ui.components.RoundCheckboxWithText
import uz.hamroh.ui.components.Section

@Composable
fun SecurityContent() {
    var firstName by remember { mutableStateOf("mingboyev.kh@gmail.com") }
    var lastName by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { HamrohTitleLargeText("Безопасность") },
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
                HamrohTitleLargeText("Email")
                HamrohOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    value = firstName,
                    enabled = false,
                    onValueChange = { firstName = it })
                Spacer(modifier = Modifier.height(16.dp))
                HamrohTitleLargeText("Пароль")
                HamrohOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    value = lastName,
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = { lastName = it })
                Spacer(modifier = Modifier.height(16.dp))
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