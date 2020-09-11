package com.example.registrodeconsumo

import androidx.lifecycle.LiveData
import com.example.registrodeconsumo.database.Pedidos
import com.example.registrodeconsumo.database.PedidosDao

class PedidosRepository (private val mPedidosDao:PedidosDao){
    //necesita la interface DAO

    val listAllPedidos: LiveData<List<Pedidos>> = mPedidosDao.getAllPedidosFromDb() //estoy creando la variable,contendrá todos datos DB

    suspend fun insertPedidos(mpedidos: Pedidos){
        mPedidosDao.insertOnePedido(mpedidos)  //llama a la  función del Dao, Inserta información
    }

    //va al DAO y trae el objeto encontrado por ID envuelto en LiveData

    fun getOneTaskByID(id : Int): LiveData<Pedidos> {
        return mPedidosDao.getOnePedidosByID(id)
    }
    
}
