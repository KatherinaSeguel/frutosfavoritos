package com.example.frutos.model.local.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.frutos.model.local.local.entities.DetalleFrutos

interface DaoDetalleFrutas {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBreedList(listBreed: List<DetalleFrutos>)

    @Query("SELECT * FROM detallefrutos_table")
    fun getAllBreedList(): LiveData<List<DetalleFrutos>>

}