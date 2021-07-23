package com.example.sprinttechnicaltest.feature.kota

import android.content.Context
import android.graphics.Picture
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprinttechnicaltest.R
import com.example.sprinttechnicaltest.databinding.ListItemKotaBinding
import com.example.sprinttechnicaltest.model.ContentKota
import com.example.sprinttechnicaltest.model.ResponseKota
import com.example.sprinttechnicaltest.util.PictureLib

class KotaAdapter(private val context: Context, private val data: ResponseKota): RecyclerView.Adapter<KotaAdapter.MyViewHolder>() {
    var itemClickListener: Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_kota, parent, false)
        return MyViewHolder(context, itemView, itemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val kotaData = getItem(position)
        holder.bind(kotaData)


    }
    private fun getItem(n:Int): ContentKota {
        return data.data.content[n]
    }

    override fun getItemCount(): Int {
        return data.data.content.size
    }
    class MyViewHolder(val context: Context, view: View, val listener: Listener?): RecyclerView.ViewHolder(view) {
        val binding = ListItemKotaBinding.bind(view)
        fun bind(kotaData: ContentKota){
            binding.tvAlamat.text = kotaData.areaName
            binding.tvKote.text = kotaData.areaName
            PictureLib.loadPicture(context,kotaData.areaPhoto,binding.ivKota)
            binding.cvKota.setOnClickListener {
                listener?.onClick(kotaData)
            }

        }
    }
    interface Listener{
        fun onClick(selected: ContentKota)
    }

}