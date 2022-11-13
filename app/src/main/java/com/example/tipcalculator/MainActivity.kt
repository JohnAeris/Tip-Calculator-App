package com.example.tipcalculator

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    TopContent()
}

@Preview
@Composable
fun TopContent() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .clip(shape = CircleShape.copy(CornerSize(12.dp)))) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(colorResource(id = R.color.pale_robin))
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "BILL: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "TIP: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "TOTAL: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            
            Spacer(modifier = Modifier.width(50.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "$ 00.0",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "$ 00.0",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "$ 00.0",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }

    }
}

/*@Preview(showBackground = true)*/
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        MyApp()
    }
}