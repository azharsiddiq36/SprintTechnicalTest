package com.example.sprinttechnicaltest.feature.akomodasihotel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.sprinttechnicaltest.model.ResponseHotel
import com.example.sprinttechnicaltest.repository.JsonRepository

class AkomodasiViewModel :ViewModel(){
    lateinit var serviceAkomodasi: ResponseHotel
    fun getKota(context: Context): ResponseHotel {
        serviceAkomodasi = JsonRepository.getAkomodasi(context)
        return serviceAkomodasi
    }
}