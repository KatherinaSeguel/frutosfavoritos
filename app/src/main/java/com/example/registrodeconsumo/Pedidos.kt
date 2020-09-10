package com.example.registrodeconsumo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_pedidos")
data class Pedidos(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,
    var item: String,
    var precio: Int,
    var cantidad:Int)