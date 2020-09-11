package com.example.registrodeconsumo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
private  const val DATA_BASE_NAME = "pedidos_db"
@Database(entities = [Pedidos::class], version = 1)
abstract class PedidosDatabase : RoomDatabase(){

    //método abstracto del DAO
     abstract fun getPedidosDao():PedidosDao

    companion object {
        @Volatile
        private  var INSTANCE: PedidosDatabase?=null

        fun getDatabase(context: Context): PedidosDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(context,
                    PedidosDatabase::class.java,DATA_BASE_NAME).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}