package com.example.frutos.model.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.frutos.Repository
import com.example.frutos.model.local.local.DataBaseFrutos
import com.example.frutos.model.local.local.entities.DetalleFrutos

class FrutosViewModel  (application: Application) : AndroidViewModel(application) { //sólo se hereda de la clase ViewModel sin contexto porque no es ROOM(androidViewmodel)
//Linea de arriba se modifica cuando después creo el ROOM

    private val mRepository: Repository
    //variable referencial al repositorio
    init{
        //se instancia el repositorio
        val fruDao = DataBaseFrutos.getDataBase(application).getFrutasDao()
        mRepository= Repository(fruDao)
        //indico el método que traerá el repository
        mRepository.getDataFromServer(mfruta = String())
    }
//primer fragmento
    fun exposeLiveDataFromServer(): LiveData<List<DetalleFrutos>> {
        return mRepository.mLiveDataPri  //devuelve un Listado de frutas observables

    }
//segundo fragmanto
    //Este elemento será observado por la vista cuando le pase el Id
    fun getOneFrutoskByID(id:String): LiveData<DetalleFrutos> {
        return mRepository.getOneFrutoskByID(id)
    }


}