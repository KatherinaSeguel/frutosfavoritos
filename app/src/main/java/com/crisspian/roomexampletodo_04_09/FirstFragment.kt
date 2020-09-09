package com.crisspian.roomexampletodo_04_09

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.crisspian.roomexampletodo_04_09.database.Task
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val task = Task(2,"Algo de prueba 10", false)
        val task1 = Task(3,"Algo de prueba 10", true)
        //val task01 = Task(1,"Algo de prueba 2", false)
        //val task03 = Task(2,"Algo de prueba 3", false)
        viewModel.insertTask(task1)
        //viewModel.insertTask(task01)
        //viewModel.insertTask(task03)
        // Escuchar liveData del ViewModel
        // Este borra todos los task
    //    viewModel.deleteAllTask()

        // instanciar el elemento visual RV
        val mRecyclerView = recyclerView
        //Instanciar el objeto de la clase adapter
        val mAdapter = TaskAdapter()
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)



        viewModel.allTask.observe(viewLifecycleOwner, Observer {
            Log.d("OBJETO", it.toString())
            mAdapter.updateDataList(it)
        })




    }
}