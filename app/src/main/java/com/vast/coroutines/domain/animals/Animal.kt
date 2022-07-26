package com.vast.coroutines.domain.animals

import com.google.gson.annotations.SerializedName

data class Animal(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image_link")
    val imageLink: String
    )