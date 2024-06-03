package uz.hamroh.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomSnackbar(snackbarData: SnackbarData) {
    Snackbar(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        HamrohButtonText(
            modifier = Modifier.fillMaxWidth(),
            text = snackbarData.visuals.message
        )
    }
}

