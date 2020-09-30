package com.example.frutos.model.remoto


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("botname")
    val botname: String,
    @SerializedName("imageurl")
    val imageurl: String,
    @SerializedName("othname")
    val othname: String,
    @SerializedName("tfvname")
    val tfvname: String
)