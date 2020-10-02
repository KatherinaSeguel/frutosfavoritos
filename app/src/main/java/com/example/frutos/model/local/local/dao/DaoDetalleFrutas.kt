package com.example.frutos.model.local.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.frutos.model.local.local.entities.DetalleFrutos

@Dao
interface DaoDetalleFrutas {
//inserta todos datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFrutosList(listaFrutos: List<DetalleFrutos>)

//Selecciona todos los datos

    @Query("SELECT * FROM detallefrutos_table")
    fun getAllFrutosList(): LiveData<List<DetalleFrutos>>

//Selecciona u objeto en específico
    @Query("SELECT * FROM detallefrutos_table WHERE imageUrl=:mid")//los : es para que sepa que es la variable
    fun getOneFrutoskByID(mid:String): LiveData<DetalleFrutos> //yo le paso un id y la query me trae el Tfruto u objeto que encuentre


//elimina toda la tabla
    @Query ("Delete FROM detallefrutos_table")
    suspend fun deleteALLFrutos()

}