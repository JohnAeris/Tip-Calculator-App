package com.example.tipcalculator.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    iconImage: Painter,
    onClick: () -> Unit,
    elevation: Dp = 4.dp,
) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .clickable {
                onClick.invoke()
            }
            .size(40.dp),
        elevation = elevation,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Image(painter = iconImage, contentDescription = "Button Icon")
    }

}