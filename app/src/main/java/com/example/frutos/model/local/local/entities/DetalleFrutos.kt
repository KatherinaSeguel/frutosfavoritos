package com.example.frutos.model.local.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detallefrutos_table")
data class DetalleFrutos (@PrimaryKey val imageUrl: String)
