package com.example.frutos.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface{

    //Detalle de la fruta
    @GET("showdetail.php?srcname={fruto}")
    fun getDataFromApi(@Path("fruto") mFrutos:String) : retrofit2.Call<Result>

   // @GET("breeds/list/")
   // suspend fun fetchBreedListCorutinas(): Response<Result>

//Buscar un fruto
    @GET("tfvjsonapi.php?search={fruto}")
    fun getDataFromApiCorutines(@Path("fruto") mFrutos:String): retrofit2.Response<Frutos>


   // @GET("breed/{breed}/images")
   // fun ImagesList(breed: String): Call<DogImagenes>

}