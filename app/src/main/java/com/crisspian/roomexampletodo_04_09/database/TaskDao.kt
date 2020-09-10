package com.crisspian.roomexampletodo_04_09.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.crisspian.roomexampletodo_04_09.database.Task

@Dao
interface TaskDao {

    // insertar un objeto en la tabla utilizando suspend de corroutinas
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneTask(mTask: Task)

    // Insertar multiples objetos Task en la tabla
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleTask(mListTask: List<Task>)

    @Update
    suspend fun updateOneTask(mTask: Task)

    @Delete
    fun deleteOneTask(mTask: Task)

    // esta funcion devolvera un listado envuelto en LiveData
    @Query("SELECT * FROM table_task")
    fun getAllTaskFromDb(): LiveData<List<Task>>

    // Busca un elemento por ID
    @Query("SELECT * FROM table_task WHERE id =:mId")
    fun getOneTaskByID(mId: Int): LiveData<Task>

    @Query("DELETE  FROM table_task")
    suspend fun deleteAllTask()


}