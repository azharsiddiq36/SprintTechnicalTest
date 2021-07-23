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
import com.example.sprinttechnicaltest.util.PictureLib

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
            binding.tvTitle.text = akomodasiData.referenceName
            binding.tvLocation.text = akomodasiData.ticketName
            binding.tvDescription.text = akomodasiData.description
            PictureLib.loadPicture(context, akomodasiData.referenceImage,binding.ivHotel)
            binding.cvHotel.setOnClickListener {
                listener?.onClick(akomodasiData)
            }

        }
    }
    interface Listener{
        fun onClick(selected: ContentHotel)
    }

}