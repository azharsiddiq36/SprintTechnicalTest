package com.example.sprinttechnicaltest.repository

import android.content.Context
import android.content.Intent
import com.example.sprinttechnicaltest.feature.akomodasihotel.AkomodasiHotelActivity
import com.example.sprinttechnicaltest.feature.kota.MainActivity

object NavigatorRepository {
    fun openKota(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
    fun openAkomodasi(context: Context){
        val intent = Intent(context, AkomodasiHotelActivity::class.java)
        context.startActivity(intent)
    }
}