package com.example.frutos.model.local.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.frutos.model.local.local.dao.DaoDetalleFrutas
import com.example.frutos.model.local.local.entities.DetalleFrutos


private const val DATA_BESE_NAME= "frutas_db"
@Database(entities=[DetalleFrutos::class], version=1 )

abstract class DataBaseFrutos : RoomDatabase(){

    //Método para DogDao
    abstract fun getFrutasDao(): DaoDetalleFrutas

    companion object{  //permite acceder a el sin necesidad de crear el objeto de la clase, nombre clase + punto y acceso a lo que está en el companen objet
        @Volatile
        private var INSTANCE:DataBaseFrutos?= null
        fun getDataBase(context: Context): DataBaseFrutos{

            val tempInstance= INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(context,
                    DataBaseFrutos::class.java,
                    DATA_BESE_NAME)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }


}