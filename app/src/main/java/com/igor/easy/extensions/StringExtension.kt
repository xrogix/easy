package com.igor.easy.extensions

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.toCurrency() : String {
    val ptBr = Locale("pt", "BR")
    return NumberFormat.getCurrencyInstance(ptBr).format(this.toDouble())
}

fun String.formatDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date = sdf.parse(this)

    val nsdf = SimpleDateFormat("dd/MM/yyyy")
    return nsdf.format(date.time)
}

fun String.toPercent(): String {
    return String.format("%s%s", this,"%")
}