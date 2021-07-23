package com.example.sprinttechnicaltest.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.sprinttechnicaltest.model.akomodasi.Response
import com.example.sprinttechnicaltest.repository.JsonRepository

class AkomodasiViewModel :ViewModel(){
    lateinit var serviceAkomodasi: Response
    fun getKota(context: Context): Response {
        serviceAkomodasi = JsonRepository.getAkomodasi(context)
        return serviceAkomodasi
    }
}