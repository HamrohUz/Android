package uz.hamroh.profile.ui.payment

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import uz.hamroh.profile.R
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohOutlinedButton
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohTitleLargeText
import uz.hamroh.ui.components.HamrohTonalButton

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PaymentContent() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { HamrohTitleLargeText("Способы оплаты") },
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
        PaymentMethodsScreen()
    }
}

@Composable
fun PaymentMethodsScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var cardNumber by remember { mutableStateOf("") }
    var expiryMonth by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }
    var cardList by remember { mutableStateOf(listOf("MasterCard 0594", "Visa 2411", "American Express 34992")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        cardList.forEach { card ->
            CardItem(card = card, onDelete = {
                cardList = cardList.filter { it != card }
            })
            Spacer(modifier = Modifier.height(8.dp))
        }

        AddNewCardButton(onClick = { showDialog = true })

        if (showDialog) {
            AddCardDialog(
                cardNumber = cardNumber,
                onCardNumberChange = { cardNumber = it },
                expiryMonth = expiryMonth,
                onExpiryMonthChange = { expiryMonth = it },
                cvv = cvv,
                onCvvChange = { cvv = it },
                onDismiss = { showDialog = false },
                onSave = {
                    cardList = cardList + "$cardNumber $expiryMonth $cvv"
                    cardNumber = ""
                    expiryMonth = ""
                    cvv = ""
                    showDialog = false
                }
            )
        }
    }
}

@Composable
fun CardItem(card: String, onDelete: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = uz.hamroh.ui.R.drawable.ic_card),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = card, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = uz.hamroh.ui.R.drawable.ic_cancel_24),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onDelete() }
            )
        }
    }
}

@Composable
fun AddNewCardButton(onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = uz.hamroh.ui.R.drawable.ic_trip_history_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Добавьте новую карту", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "Чтобы оплачивать поездки и не волноваться о том, что забудете. Мы об этом позаботимся", fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun AddCardDialog(
    cardNumber: String,
    onCardNumberChange: (String) -> Unit,
    expiryMonth: String,
    onExpiryMonthChange: (String) -> Unit,
    cvv: String,
    onCvvChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onSave: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Добавить карту", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                HamrohOutlinedTextField(
                    value = cardNumber,
                    onValueChange = onCardNumberChange,
                    label = { Text("Номер карты") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                HamrohOutlinedTextField(
                    value = expiryMonth,
                    onValueChange = onExpiryMonthChange,
                    label = { Text("Месяц окончания") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                HamrohOutlinedTextField(
                    value = cvv,
                    onValueChange = onCvvChange,
                    label = { Text("CVV") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    HamrohOutlinedButton(onClick = onDismiss) {
                        HamrohButtonText("Отмена")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    HamrohFilledButton(onClick = onSave) {
                        HamrohButtonText("Сохранить")
                    }
                }
            }
        }
    }
}
