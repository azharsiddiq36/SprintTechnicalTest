package com.example.sprinttechnicaltest.feature.kota

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.sprinttechnicaltest.model.ResponseKota
import com.example.sprinttechnicaltest.repository.JsonRepository

class KotaViewModel:ViewModel() {
    lateinit var serviceKota: ResponseKota
    fun getKota(context: Context): ResponseKota {
        serviceKota = JsonRepository.getKota(context)
        return serviceKota
    }
}