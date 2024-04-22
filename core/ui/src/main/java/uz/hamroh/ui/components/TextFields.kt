package uz.hamroh.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.hamroh.ui.R
import uz.hamroh.ui.extensions.clearFocusOnKeyboardDismiss
import uz.hamroh.ui.theme.HamrohTheme


@Preview
@Composable
private fun TextFieldPreview() {
    HamrohTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            var text by remember {
                mutableStateOf("")
            }
            HamrohOutlinedTextField(label = { Text(text = "test")}, value = text, onValueChange = {text = it})
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HamrohOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onCancel: () -> Unit = { onValueChange("") },
    enabled: Boolean = true,
    showKeyboard: Boolean = false,
    isFocused: MutableState<Boolean> = remember { mutableStateOf(false) },
    focusRequester: FocusRequester = remember { FocusRequester() },
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = defaultTrailingContent(
        isError = isError,
        onClick = onCancel,
        value = value,
        enabled = enabled,
        isFocused = isFocused.value
    ),
    supportingText: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
) {
    if (showKeyboard) {
        LaunchedEffect(Unit) { focusRequester.requestFocus() }
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            }
            .clearFocusOnKeyboardDismiss(),
        enabled = enabled,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HamrohOutlinedTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onCancel: () -> Unit = { onValueChange(TextFieldValue()) },
    enabled: Boolean = true,
    showKeyboard: Boolean = false,
    isFocused: MutableState<Boolean> = remember { mutableStateOf(false) },
    focusRequester: FocusRequester = remember { FocusRequester() },
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = defaultTrailingContent(
        isError = isError,
        onClick = onCancel,
        value = value.text,
        enabled = enabled,
        isFocused = isFocused.value,
    ),
    supportingText: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
) {
    if (showKeyboard) {
        LaunchedEffect(Unit) { focusRequester.requestFocus() }
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            }
            .clearFocusOnKeyboardDismiss(),
        enabled = enabled,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
    )
}

@Composable
fun defaultTrailingContent(
    isError: Boolean,
    onClick: () -> Unit,
    value: String,
    enabled: Boolean,
    isFocused: Boolean,
    trailingIcon: @Composable () -> Unit = {
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cancel_24),
                contentDescription = null
            )
        }
    }
): @Composable (() -> Unit)? =
    when {
        isError && !isFocused -> {
            {
                Icon(
                    painter = painterResource(id = R.drawable.ic_error_24),
                    contentDescription = null
                )

            }
        }
        value.isNotEmpty() && enabled -> {
            { trailingIcon() }
        }
        else -> null
    }