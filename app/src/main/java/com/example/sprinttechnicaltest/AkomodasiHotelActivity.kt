package com.example.sprinttechnicaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprinttechnicaltest.adapter.AkomodasiAdapter
import com.example.sprinttechnicaltest.databinding.ActivityAkomodasiHotelBinding
import com.example.sprinttechnicaltest.model.akomodasi.Content
import com.example.sprinttechnicaltest.model.akomodasi.Response
import com.example.sprinttechnicaltest.repository.NavigatorRepository
import com.example.sprinttechnicaltest.viewmodel.AkomodasiViewModel

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

    private fun initrecycler(vmKota: Response) {
        akomodasiAdapter = AkomodasiAdapter(this,vmKota)
        binding.recyclerHotel.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = akomodasiAdapter
            akomodasiAdapter!!.itemClickListener = object : AkomodasiAdapter.Listener {
                override fun onClick(selected: Content) {
                    Toast.makeText(context, "Kentang", Toast.LENGTH_SHORT).show()
                    NavigatorRepository.openDetailKota(context)
                }
            }
        }
    }
}