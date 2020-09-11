package com.example.registrodeconsumo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PedidosDao {

    @Insert
    suspend  fun insertOnePedido(mpedi: Pedidos)  //función al objeto mpedi  le asigno la clase Pedidos
    @Update
    suspend  fun updateOnePedidos(mpedi: Pedidos)  //función que Modifica

    @Delete
    fun deleteOnePedidos(mpedi: Pedidos) // función delete
   // suspend fun deleteALLPedido()

    @Query ("SELECT * FROM table_pedidos")
   // fun getAllTaskFromDb(): LiveData<List<Pedidos>> //se envuelve el LIST en LiveData

  //  @Query("SELECT * FROM table_pedidos WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOneTaskByID(mid:Int): LiveData<Pedidos>     //yo le paso un id y la query me trae el un objeto que encuentre

}