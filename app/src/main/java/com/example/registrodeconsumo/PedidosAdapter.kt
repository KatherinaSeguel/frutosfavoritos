package com.example.registrodeconsumo

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodeconsumo.database.Pedidos
import kotlinx.android.synthetic.main.pedidos_item_list.view.*

class PedidosAdapter(val list:List<Pedidos>) : RecyclerView.Adapter<PedidosAdapter.PedidosViewHolder>() {

    inner class PedidosViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val pediText= itemView.iditem
        val pediprecio = itemView.precio
        val pedicant=itemView.cant

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidosViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PedidosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}