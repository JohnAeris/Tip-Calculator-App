package com.example.tipcalculator.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RectangleButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    elevation: Dp = 4.dp
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick
            }
            .wrapContentHeight()
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}