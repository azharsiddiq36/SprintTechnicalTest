package com.example.sprinttechnicaltest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprinttechnicaltest.R
import com.example.sprinttechnicaltest.databinding.ListItemKotaBinding
import com.example.sprinttechnicaltest.model.kota.Content
import com.example.sprinttechnicaltest.model.kota.ResponseKota

class KotaAdapter(private val context: Context, private val data: ResponseKota): RecyclerView.Adapter<KotaAdapter.MyViewHolder>() {
    var itemClickListener:Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KotaAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_kota, parent, false)
        return MyViewHolder(context, itemView, itemClickListener)
    }

    override fun onBindViewHolder(holder: KotaAdapter.MyViewHolder, position: Int) {
        val kotaData = getItem(position)
        holder.bind(kotaData)


    }
    private fun getItem(n:Int):Content{
        return data.data.content[n]
    }

    override fun getItemCount(): Int {
        return data.data.content.size
    }
    class MyViewHolder(val context: Context, view: View, val listener:Listener?): RecyclerView.ViewHolder(view) {
        val binding = ListItemKotaBinding.bind(view)
        fun bind(kotaData: Content){
            binding.tvMovie.text = kotaData.areaName
            binding.cvMovie.setOnClickListener {
                listener?.onClick(kotaData)
            }

        }
    }
    interface Listener{
        fun onClick(selected:Content)
    }

}