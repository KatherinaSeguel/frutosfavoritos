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
import com.example.frutos.model.ui.FrutosViewModel
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    lateinit var mViewModel: FrutosViewModel
    var idfrutos: String? = null   //saqué private

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel =
            ViewModelProvider(this).get(FrutosViewModel::class.java) //variable representa VM
        arguments?.let {
            idfrutos = it.getString("id","")   //se pasa la key de la clase
            Log.d("LET",idfrutos.toString())
        }
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idfrutos?.let {
            Log.d("ingresé al LET","")
            //la función debe devolver LiveData
            mViewModel.getOneFrutoskByID(it).observe(viewLifecycleOwner,Observer{
                Log.d("OBJ_LIVE",it.toString())


                idtextView1.setText(it.botname)

                idtextView2.setText(it.tfvname)

                Log.d("seg",it.imageUrl)
            })

        }

        button_second.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }
}