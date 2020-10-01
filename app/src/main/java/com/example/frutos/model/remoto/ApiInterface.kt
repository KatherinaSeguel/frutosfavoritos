package com.example.frutos.model.remoto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface{

    // @GET("breed/{breed}/images")
    // fun ImagesList(breed: String): Call<DogImagenes>

    //Detalle de la fruta
    @GET("showdetail.php?srcname={fruto}")  //Llega un Listado de Frutos y Frutos es un List de Result(Aquí vienen con detalles)
    fun getDataFromApi(@Path("fruto") mFrutos:String) : Call<Frutos>

   // @GET("breeds/list/")
   // suspend fun fetchBreedListCorutinas(): Response<Result>

//Buscar un fruto
    @GET("tfvjsonapi.php?search={fruto}")
    fun getDataFromApiCorutines(@Path("fruto") mFrutos:String): retrofit2.Response<Frutos>




}