package com.example.sprinttechnicaltest.feature.kota

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprinttechnicaltest.databinding.ActivityMainBinding
import com.example.sprinttechnicaltest.model.ContentKota
import com.example.sprinttechnicaltest.model.ResponseKota
import com.example.sprinttechnicaltest.repository.NavigatorRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var kotaAdapter: KotaAdapter? = null
    private lateinit var kotaViewModel: KotaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKota()
    }

    private fun loadKota() {
        kotaViewModel = ViewModelProvider(this).get(KotaViewModel::class.java)
        this?.let {
            var vmKota = kotaViewModel.getKota(this)
                initrecycler(vmKota)

        }
    }

    private fun initrecycler(vmKota: ResponseKota) {
        kotaAdapter = KotaAdapter(this,vmKota)
        binding.recyclerKota.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = kotaAdapter
            kotaAdapter!!.itemClickListener = object : KotaAdapter.Listener {
                override fun onClick(selected: ContentKota) {
                    Toast.makeText(context, "Kentang", Toast.LENGTH_SHORT).show()
                    NavigatorRepository.openDetailKota(context)
                }
            }
        }
    }
}