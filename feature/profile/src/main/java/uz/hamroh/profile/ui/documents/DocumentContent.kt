package uz.hamroh.profile.ui.documents

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import uz.hamroh.ui.components.HamrohButtonText
import uz.hamroh.ui.components.HamrohFilledButton
import uz.hamroh.ui.components.HamrohOutlinedTextField
import uz.hamroh.ui.components.HamrohTitleLargeText


@Composable
fun DocumentContent(){
    Content()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Content() {
    var documentName by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { HamrohTitleLargeText("Документы") },
                navigationIcon = {
                    androidx.compose.material.IconButton(onClick = { /* Handle back navigation */ }) {
                        androidx.compose.material.Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Название документа",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            HamrohOutlinedTextField(
                value = documentName,
                onValueChange = { documentName = it },
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            HamrohFilledButton(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                HamrohButtonText("Загрузить фотографию")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (imageUrl.isNotEmpty()) {
                val painter: Painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .build()
                )
                Image(
                    painter = painter,
                    contentDescription = "Загруженное изображение",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            HamrohFilledButton(
                onClick = { /* Действие при нажатии */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                HamrohButtonText(
                    text = "Сохранить документ",
                )
            }
        }
    }
}