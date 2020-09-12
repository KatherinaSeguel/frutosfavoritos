package com.example.registrodeconsumo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodeconsumo.database.Pedidos
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.pedidos_item_list.view.*
import kotlinx.android.synthetic.main.pedidos_item_list.view.cantTv
import kotlinx.android.synthetic.main.pedidos_item_list.view.precioTv

class PedidosAdapter() : RecyclerView.Adapter<PedidosAdapter.PedidosViewHolder>() {

 private var  dataList= emptyList<Pedidos>()  //genera Listado vacío y así no da problamas de instanciación

    fun updateDataList(mDataList: List<Pedidos>){
        //este método actualiza la Lista
        dataList=mDataList
        notifyDataSetChanged() //cada vez que actualiza el adapter el notifica

    }

    inner class PedidosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val pediText= itemView.idItemTv
        val pediprecio = itemView.precioTv
        val pedicant=itemView.cantTv
        val pedid = itemView.idTv

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidosViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.pedidos_item_list,parent,false)

        return PedidosViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: PedidosViewHolder, position: Int) {
       val mPedidos: Pedidos = dataList[position]
        holder.pediText.text= mPedidos.item
        holder.pediprecio.text= mPedidos.precio.toString()
        holder.pedicant.text= mPedidos.precio.toString()
        holder.pedid.text= mPedidos.id.toString()

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}