package com.example.frutos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frutos.model.ui.FrutosViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    //1) Declaro variable del View Model
    lateinit var mViewModel: FrutosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {  // 2.0  se crea este método
        super.onCreate(savedInstanceState)
        //2.1) asigno el View Model a esta vista
        mViewModel= ViewModelProvider(this).get(FrutosViewModel::class.java)

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

        //3) observo la finción que retorna del LiveData desde ViewModel
        mViewModel.exposeLiveDataFromServer().observe(viewLifecycleOwner, Observer {
            Log.d("View",it.toString())
        })
/*//viene después
        val mRecyclerView = idrecyclerView
        val mdapter= FrutosAdapter(this)
        mRecyclerView.adapter=mdapter
        mRecyclerView.layoutManager= LinearLayoutManager(context)*/

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}