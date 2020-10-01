package com.example.frutos

import com.example.frutos.model.local.local.DataBaseFrutos
import com.example.frutos.model.local.local.dao.DaoDetalleFrutas
import com.example.frutos.model.local.local.entities.DetalleFrutos
import com.example.frutos.model.remoto.Frutos
import com.example.frutos.model.remoto.RetrofitCliente
import retrofit2.Callback

class Repository (private val frutosDao: DaoDetalleFrutas) {
    private val service = RetrofitCliente.getRetrofitClient()
    val mLiveData = frutosDao.getAllFrutosList()

    //La vieja confiable
    fun getDataFromServer(mfruta:String){
        val call = service.getDataFromApi(mfruta)
        call.enqueue(object : Callback<DetalleFrutos>)


}