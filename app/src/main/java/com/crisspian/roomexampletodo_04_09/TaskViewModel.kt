package com.crisspian.roomexampletodo_04_09

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.crisspian.roomexampletodo_04_09.database.Task
import com.crisspian.roomexampletodo_04_09.database.TaskDatabase
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository
    val allTask: LiveData<List<Task>>

    init {
        val taskDao = TaskDatabase.getDatabase(application).getTaskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.listAllTask
    }

    fun insertTask(task: Task) = viewModelScope.launch {
        repository.insertTask(task)
    }

    //delete all task from database
      fun deleteAllTask() = viewModelScope.launch {
        repository.deleteAll()
    }

    // Este metodo sera observado por la vista cuando le pase el ID
    fun getOneTaskByID(id : Int) : LiveData<Task> {
         return repository.getOneTaskByID(id)
    }

    // Este metodo hace update
    fun updateTask(mTask: Task) = viewModelScope.launch {
        repository.updateTask(mTask)
    }

}