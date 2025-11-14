package com.example.unisuki.model

class CardItem {
    private var title: String = ""
    private var itemimage: String = ""
    private var size: String = ""
    private var color: String = ""
    private var price: Double = 0.0
    private var description: String = ""
    private var tags: List<String> = emptyList()

    constructor(
        title: String,
        itemimage: String,
        size: String,
        color: String,
        price: Double,
        description: String,
        tags: List<String>,
        hasNotification: Boolean,
        additionalImage: List<String>
    ) {
        this.title = title
        this.itemimage = itemimage
        this.size = size
        this.color = color
        this.price = price
        this.description = description
        this.tags = tags
        this.hasNotification = hasNotification
        this.additionalImage = additionalImage
    }

    private var additionalImage: List<String> = emptyList()
    private var hasNotification: Boolean = false
}