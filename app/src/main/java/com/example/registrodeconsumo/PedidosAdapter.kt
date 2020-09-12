package com.example.registrodeconsumo

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodeconsumo.database.Pedidos
import kotlinx.android.synthetic.main.pedidos_item_list.view.*

class PedidosAdapter(val dataList:List<Pedidos>) : RecyclerView.Adapter<PedidosAdapter.PedidosViewHolder>() {

    inner class PedidosViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val pediText= itemView.iditem
        val pediprecio = itemView.precio
        val pedicant=itemView.cant

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidosViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate((R.layout.pedidos_item_list,parent,false))

        return PedidosViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: PedidosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}