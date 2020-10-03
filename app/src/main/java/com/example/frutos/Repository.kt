package com.example.frutos

import android.util.Log
import com.example.frutos.model.local.local.dao.DaoDetalleFrutas
import com.example.frutos.model.local.local.entities.DetalleFrutos
import com.example.frutos.model.remoto.Frutos
import com.example.frutos.model.remoto.Result
import com.example.frutos.model.remoto.RetrofitCliente
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (private val frutosDao: DaoDetalleFrutas) {
    private val service = RetrofitCliente.getRetrofitClient()
    val mLiveData = frutosDao.getOneFrutoskByID(mid = String())
    val mLiveDataPri=frutosDao.getAllFrutosList()

    //La vieja confiable
    fun getDataFromServer(mfruta:String) {
        val call = service.getDataFromApi()
        call.enqueue(object : Callback<Frutos> {


            override fun onFailure(call: Call<Frutos>, t: Throwable) {
                Log.e("Repository",t.message.toString())

            }

            override fun onResponse(call: Call<Frutos>, response: Response<Frutos>)
            {
                when(response.code()){
                    //***se cambia***  in 200..299 -> mLiveData.postValue(response.body())
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {

                            Log.d("Info",it.toString())
                            frutosDao.insertAllFrutosList(converter(it.results))

                        }
                    }
                    in 300..399 -> Log.d("ERROR 300",response.errorBody().toString())
                    in 400..499 -> Log.d("ERROR 400",response.errorBody().toString())
                }
            }


        }) //llamadas asincronas

    }

  // En este metodo paso de datos o objeto  ,, varieble listadoDeRazas= listadoDeFrutas
    //se hace este función si lo que trae la database es distinto a lo que yo quiero en el ROOM
    //Aquí lo transformo.
    fun converter(list: List<Result>):List<DetalleFrutos>{

        var listadoDeFrutas:MutableList<DetalleFrutos> = mutableListOf<DetalleFrutos>()
        list.map {
            listadoDeFrutas.add(DetalleFrutos(it.imageurl,it.botname,it.othname,it.tfvname))
        }
        return listadoDeFrutas
    }

}