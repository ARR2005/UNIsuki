package com.example.test_unisuki.model

data class Item(
    val categoryId: String = "",
    val description: String = "",
    val model: String = "",
    val picUrl: String = "",
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val showRecommended: Boolean = false,
    val title: String = ""
)