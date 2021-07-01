package com.example.cardstacksample.model

data class Card(
    val name: String,
    val age: Int,
    val country: String,
    val profileImageList: ArrayList<ProfileImage>,
    var currentProfileImagePosition: Int = 0,
)

data class ProfileImage(
    val image: String,
)
