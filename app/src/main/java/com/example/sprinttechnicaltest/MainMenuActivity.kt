package com.example.sprinttechnicaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprinttechnicaltest.databinding.ActivityMainBinding
import com.example.sprinttechnicaltest.databinding.ActivityMainMenuBinding
import com.example.sprinttechnicaltest.repository.NavigatorRepository

class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickListener()
    }

    private fun initClickListener() {
        binding.tvHotel.setOnClickListener {
            NavigatorRepository.openAkomodasi(context = this)
        }
        binding.tvKota.setOnClickListener {
            NavigatorRepository.openKota(context = this)
        }
    }
}