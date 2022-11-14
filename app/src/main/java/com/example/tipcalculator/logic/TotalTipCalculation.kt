package com.example.tipcalculator.logic


fun totalTipCalculation(totalBill: Double, tipPercentage: Int): Double {
    return if (totalBill > 1 && totalBill.toString().isNotEmpty()) {
        (totalBill * tipPercentage) / 100
    } else {
        0.0
    }
}

fun totalAmountPerPerson(totalBill: Double, split: Int, tipPercentage: Int): Double {
    val bill = totalTipCalculation(totalBill = totalBill, tipPercentage = tipPercentage)
    return (bill/split)
}