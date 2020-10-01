package com.example.frutos

import com.example.frutos.model.local.local.dao.DaoDetalleFrutas
import com.example.frutos.model.local.local.entities.DetalleFrutos
import com.example.frutos.model.remoto.Frutos
import com.example.frutos.model.remoto.RetrofitCliente
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (private val frutosDao: DaoDetalleFrutas) {
    private val service = RetrofitCliente.getRetrofitClient()
    val mLiveData = frutosDao.getAllFrutosList()

    //La vieja confiable
    fun getDataFromServer(mfruta:String) {
        val call = service.getDataFromApi(mfruta)
        call.enqueue(object : Callback<Frutos> {


            override fun onFailure(call: Call<Frutos>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Frutos>, response: Response<Frutos>) {
                TODO("Not yet implemented")
            }


        }) //llamadas asincronas

    }

  /* // En este metodo paso de datos o objeto  ,, varieble listadoDeRazas= listadoDeFrutas
    fun converter(list:List<String>):List<DetalleFrutos>{

        var listadoDeFrutas:MutableList<DetalleFrutos> = mutableListOf<DetalleFrutos>()
        list.map {
            listadoDeFrutas.add(DetalleFrutos(it))
        }
        return listadoDeFrutas
    }*/

}