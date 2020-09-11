package com.example.registrodeconsumo

import com.example.registrodeconsumo.database.Pedidos
import com.example.registrodeconsumo.database.PedidosDao

class PedidosRepository (private val mPedidosDao:PedidosDao){
    //necesita la interface DAO

    suspend fun insertPedidos(mpedidos: Pedidos){
        mPedidosDao.insertOnePedido(mpedidos)  //llama a la  función del Dao, Inserta información
    }
//esta función delete all

    suspend fun deleteALL(){
        mPedidosDao.deleteOnePedidos()
    }

}