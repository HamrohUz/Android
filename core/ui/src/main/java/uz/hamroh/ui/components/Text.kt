package uz.hamroh.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.hamroh.ui.theme.HamrohTheme
import uz.hamroh.ui.theme.Typography

@Preview
@Composable
private fun TextPreview() {
    HamrohTheme {
        HamrohHeaderText(text = "Создайте аккаунт")
    }
}

@Composable
fun HamrohHeaderText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun HamrohTitleLargeText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleLarge,
    )
}

@Composable
fun HamrohDescriptionText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        color = MaterialTheme.colorScheme.tertiary,
        style = Typography.bodyMedium,
    )
}

@Composable
fun HamrohSmallText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        color = MaterialTheme.colorScheme.primary,
        style = Typography.labelMedium,
    )
}

@Composable
fun HamrohButtonText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.padding(vertical = 6.dp),
        text = text,
        textAlign = TextAlign.Center,
        style = Typography.bodyLarge,
    )
}