package com.example.tipcalculator

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.components.InputTextField
import com.example.tipcalculator.components.IconButton
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
    Column(modifier = Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)) {

        TopContent()
        BodyContent()

    }
}

//@Preview
@Composable
fun TopContent(
    bill: Double = 0.0,
    tip: Double = 0.0,
    split: Int = 0,
    total: Double = 0.0
) {

    var billD = "%.2f".format(bill)
    var tipD = "%.2f".format(tip)
    var totalD = "%.2f".format(total)

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .clip(shape = CircleShape.copy(CornerSize(12.dp)))) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(colorResource(R.color.pale_robin))
        ) {
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = "Bill: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Tip: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Split: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Total: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            
            Spacer(modifier = Modifier.width(50.dp))

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "$ $billD",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "$ $tipD",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "0",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "$ $totalD",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview
@Composable
fun BodyContent() {

    UserForm() { bill ->
        Log.d("AMOUNT", "User's Input: $bill")
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {}
) {
    var bill = remember {
        mutableStateOf("")
    }

    val isBillValid = remember(bill.value) {
        bill.value.trim().isNotEmpty()
    }

    var split by remember {
        mutableStateOf(0)
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(8.dp)),
        border = BorderStroke(1.dp, color = colorResource(R.color.teal_blue)) ) {

        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            //Text Field

            InputTextField(
                state = bill,
                label = "Enter the amount",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!isBillValid) {
                        Toast.makeText(context, "Input the bill", Toast.LENGTH_SHORT).show()
                        return@KeyboardActions}
                    else {
                        onValueChange(bill.value.trim())
                        keyboardController?.hide()
                    }
                }
            )

            if (isBillValid) {

                Text(
                    text = "SPLIT",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 10.dp)
                ) {

                    IconButton(
                        iconImage = painterResource(R.drawable.minus_ic),
                        onClick = {
                            if (split > 0) {
                                split--
                            } else {
                                split = 0
                            }
                        })

                    Spacer(modifier = Modifier.width(20.dp))

                    Row() {
                        Image(
                            painter = painterResource(R.drawable.user_ic),
                            contentDescription = "Number of person",
                            modifier = Modifier.size(28.dp),
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "$split",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    IconButton(
                        iconImage = painterResource(R.drawable.add_ic),
                        onClick = {
                            split++
                        }
                    )
                }

            } else {

            }




        }
    }
}




//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        MyApp()
    }
}