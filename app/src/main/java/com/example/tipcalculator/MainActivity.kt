package com.example.tipcalculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.tipcalculator.logic.totalAmountPerPerson
import com.example.tipcalculator.logic.totalTipCalculation
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import kotlin.math.absoluteValue

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

        BodyContent()

    }
}

@Preview
@Composable
fun TopContent(
    bill: String = "0.0",
    tip: Double = 0.0,
    split: Int = 1,
    individualAmount: Double = 0.0
) {

    var tipD = "%.2f".format(tip)
    //var totalD = "%.2f".format(total)

    val billA = if (bill.isNullOrEmpty()) {
        0.0
    } else {
        bill.toDouble()
    }

    var total = billA + tip

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(230.dp)
        .padding(start = 10.dp, end = 10.dp)
        .clip(shape = CircleShape.copy(CornerSize(12.dp)))) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "TOTAL AMOUNT",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            
            Text(
                text = "$ $total",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Divider(thickness = 1.dp)

            Row(modifier = Modifier.padding(top = 10.dp)) {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "Bill",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Split",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Tip",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Per Person\n(Tip)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Spacer(modifier = Modifier.width(50.dp))

                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(
                        text = ":",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = ":",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = ":",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = ":",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Spacer(modifier = Modifier.width(50.dp))

                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "$$billA",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$split",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$$tipD",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$$individualAmount",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }




        }

        /*Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(colorResource(R.color.pale_robin))
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Total",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Bill",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                Text(
                    text = "Tip",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                Text(
                    text = "Split",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Per Person",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            
            Spacer(modifier = Modifier.width(20.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "$ $billA",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                Text(
                    text = "$ $tipD",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                Text(
                    text = "$split",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "$ $individualAmount",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "$ $total",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }*/
    }
}

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
        mutableStateOf(1)
    }

    var tipSlider by remember {
        mutableStateOf(0f)
    }

    var tipPercentage = (tipSlider * 100).toInt()

    var tipAmount by remember {
        mutableStateOf(0.0)
    }

    var amountPerPerson by remember {
        mutableStateOf(0.0)
    }

    var amountPerPersonD = "%.2f".format(amountPerPerson)

    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    TopContent(
        bill = bill.value,
        tip = tipAmount,
        split = split,
        individualAmount = amountPerPersonD.toDouble()
    )

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
                        onValueChange(bill.toString().trim())
                        keyboardController?.hide()
                    }
                }
            )

            if (isBillValid) {

                //SPLIT
                
                Spacer(modifier = Modifier.height(10.dp))

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
                            if (split > 1) {
                                split--
                                amountPerPerson = totalAmountPerPerson(
                                    totalBill = bill.value.toDouble(),
                                    split = split.absoluteValue,
                                    tipPercentage = tipPercentage
                                )
                            } else {
                                split = 1
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
                            amountPerPerson = totalAmountPerPerson(
                                totalBill = bill.value.toDouble(),
                                split = split.absoluteValue,
                                tipPercentage = tipPercentage
                            )
                        }
                    )
                }
                
                Spacer(modifier = Modifier.height(20.dp))

                //TIP

                Text(
                    text = "TIP",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp)
                )

                Text(
                    text = "$$tipAmount",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .align(Alignment.End)
                )

                Text(
                    text = "$tipPercentage%",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .align(Alignment.End)
                )

                Slider(
                    value = tipSlider,
                    onValueChange = { value ->
                        Log.d("SliderState", "Slider value: $value ")
                        tipSlider = value

                        tipAmount = totalTipCalculation(bill.value.toDouble(), tipPercentage)
                        amountPerPerson = totalAmountPerPerson(
                            totalBill = bill.value.toDouble(),
                            split = split.absoluteValue,
                            tipPercentage = tipPercentage
                        )
                    },
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
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