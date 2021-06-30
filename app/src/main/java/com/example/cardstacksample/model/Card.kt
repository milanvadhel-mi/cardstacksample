package com.example.cardstacksample

data class Card(
    val name : String,
    val age : Int,
    val country : String,
    val profileImageList : ArrayList<ProfileImage>
)

data class ProfileImage(
    val image : String
)
