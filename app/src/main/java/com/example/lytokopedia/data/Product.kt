package com.example.lytokopedia.data

data class Product(
    val id: String? = null,
    val name: String?,
    val harga: Int?,
    val pengirirman: String?,
    val terjual: Int?,
    val rating: Double?,
    val discount: Int,
    val grosir: Boolean = false,
    val image: Int,
)