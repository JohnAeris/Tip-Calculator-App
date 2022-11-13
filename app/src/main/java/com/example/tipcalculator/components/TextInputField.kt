package com.example.tipcalculator.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.R

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    state: MutableState<String>,
    label: String,
    enabled: Boolean,
    isSingleLine: Boolean,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    
    OutlinedTextField(
        value = state.value,
        onValueChange = { state.value = it },
        label = { Text(text = label) },
        leadingIcon = { Icon(
            painter = painterResource(id = R.drawable.dollar_ic),
            contentDescription = "Dollar Sign",
            modifier = Modifier.size(20.dp)
        ) },
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .fillMaxWidth()
    )
    
}