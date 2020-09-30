package com.example.frutos.model.remoto


import com.google.gson.annotations.SerializedName

data class Frutos(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("tfvcount")
    val tfvcount: Int
)