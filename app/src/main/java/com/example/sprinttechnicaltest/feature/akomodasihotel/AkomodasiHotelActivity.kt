package com.example.sprinttechnicaltest.feature.akomodasihotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprinttechnicaltest.databinding.ActivityAkomodasiHotelBinding
import com.example.sprinttechnicaltest.model.ContentHotel
import com.example.sprinttechnicaltest.model.ResponseHotel
import com.example.sprinttechnicaltest.repository.NavigatorRepository

class AkomodasiHotelActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAkomodasiHotelBinding
    private var akomodasiAdapter: AkomodasiAdapter? = null
    private lateinit var akomodasiViewModel: AkomodasiViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAkomodasiHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadHotel()
    }

    private fun loadHotel() {
        akomodasiViewModel = ViewModelProvider(this).get(AkomodasiViewModel::class.java)
        this?.let {
            var vmKota = akomodasiViewModel.getKota(this)
            initrecycler(vmKota)

        }
    }

    private fun initrecycler(vmKota: ResponseHotel) {
        akomodasiAdapter = AkomodasiAdapter(this,vmKota)
        binding.recyclerHotel.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = akomodasiAdapter
            akomodasiAdapter!!.itemClickListener = object : AkomodasiAdapter.Listener {
                override fun onClick(selected: ContentHotel) {
                    Toast.makeText(context, "Kentang", Toast.LENGTH_SHORT).show()
                    NavigatorRepository.openDetailKota(context)
                }
            }
        }
    }
}