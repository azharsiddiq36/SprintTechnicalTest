package com.example.sprinttechnicaltest.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sprinttechnicaltest.model.kota.ResponseKota
import com.example.sprinttechnicaltest.repository.JsonRepository

class KotaViewModel:ViewModel() {
    lateinit var serviceKota: ResponseKota
    fun getKota(context: Context): ResponseKota {
        serviceKota = JsonRepository.getKota(context)
        return serviceKota
    }
}