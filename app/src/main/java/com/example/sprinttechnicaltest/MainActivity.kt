package com.example.sprinttechnicaltest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprinttechnicaltest.adapter.KotaAdapter
import com.example.sprinttechnicaltest.databinding.ActivityMainBinding
import com.example.sprinttechnicaltest.model.kota.Content
import com.example.sprinttechnicaltest.model.kota.ResponseKota
import com.example.sprinttechnicaltest.repository.JsonRepository
import com.example.sprinttechnicaltest.repository.NavigatorRepository
import com.example.sprinttechnicaltest.viewmodel.KotaViewModel
import java.io.IOException
import java.io.InputStream

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
                override fun onClick(selected: Content) {
                    Toast.makeText(context, "Kentang", Toast.LENGTH_SHORT).show()
                    NavigatorRepository.openDetailKota(context)
                }
            }
        }
    }
}