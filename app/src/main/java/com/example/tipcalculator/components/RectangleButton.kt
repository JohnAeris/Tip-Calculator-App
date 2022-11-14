package com.example.tipcalculator.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.R

@Composable
fun RectangleButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    elevation: Dp = 4.dp
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            },
        elevation = elevation,
        shape = RoundedCornerShape(CornerSize(8.dp)),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.cool_black)),
        backgroundColor = colorResource(id = R.color.teal_blue)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp),
            color = Color.White
        )
    }
}