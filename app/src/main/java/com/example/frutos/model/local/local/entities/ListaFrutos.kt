package com.example.frutos.model.local.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista_frutos_table")
data class ListaFrutos(@PrimaryKey val id: Int)
