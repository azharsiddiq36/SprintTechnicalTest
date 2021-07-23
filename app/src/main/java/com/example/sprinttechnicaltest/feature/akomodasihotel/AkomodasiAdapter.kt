package com.example.sprinttechnicaltest.feature.akomodasihotel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprinttechnicaltest.R
import com.example.sprinttechnicaltest.databinding.ListItemAkomodasiBinding
import com.example.sprinttechnicaltest.model.ContentHotel
import com.example.sprinttechnicaltest.model.ResponseHotel

class AkomodasiAdapter(private val context: Context,private val data: ResponseHotel):RecyclerView.Adapter<AkomodasiAdapter.MyViewHolder>() {
    var itemClickListener: Listener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_akomodasi, parent, false)
        return MyViewHolder(context, itemView, itemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val akomodasiData = getItem(position)
        holder.bind(akomodasiData)


    }
    private fun getItem(n:Int): ContentHotel {
        return data.data.content[n]
    }

    override fun getItemCount(): Int {
        return data.data.content.size
    }
    class MyViewHolder(val context: Context, view: View, val listener: Listener?):RecyclerView.ViewHolder(view) {
        val binding = ListItemAkomodasiBinding.bind(view)
        fun bind(akomodasiData: ContentHotel){
            binding.tvMovie.text = akomodasiData.ticketName
            binding.cvMovie.setOnClickListener {
                listener?.onClick(akomodasiData)
            }

        }
    }
    interface Listener{
        fun onClick(selected: ContentHotel)
    }

}