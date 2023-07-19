package com.jhaghera.myapplication

data class Medicine(
    val name: String = "",
    val dosage: String = "",
    val manufacturer: String = "",
    val expiryDate: String = "",
    val price: Double = 0.0,
    val stock: Int = 0,
    val pharmacy: String = ""
)
