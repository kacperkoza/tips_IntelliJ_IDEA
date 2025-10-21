package com.example.tips_IntelliJ_IDEA.offer

import java.net.URI

data class Offers(
    val offers: List<Offer>,
)

data class Offer(
    val id: Long,
    val title: String,
    val image: URI,
)