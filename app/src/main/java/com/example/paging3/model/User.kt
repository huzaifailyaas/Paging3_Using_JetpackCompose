package com.example.paging3.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class User(
    @SerialName("links")
    @Embedded
    val userLink:UserLinks,
    val userName:String
)
