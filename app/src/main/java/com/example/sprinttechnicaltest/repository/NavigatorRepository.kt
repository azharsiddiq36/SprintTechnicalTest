package com.example.sprinttechnicaltest.repository

import android.content.Context
import android.content.Intent
import com.example.rdiandroiddevelopertest.enum.Constant
import com.example.sprinttechnicaltest.AkomodasiHotelActivity
import com.example.sprinttechnicaltest.MainActivity

object NavigatorRepository {
    fun openDetailKota(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
    fun openKota(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
    fun openAkomodasi(context: Context){
        val intent = Intent(context, AkomodasiHotelActivity::class.java)
        context.startActivity(intent)
    }
}