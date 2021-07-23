package com.example.sprinttechnicaltest.repository

import android.content.Context
import android.util.Log
import com.example.rdiandroiddevelopertest.enum.Constant
import com.example.sprinttechnicaltest.model.ResponseHotel
import com.example.sprinttechnicaltest.model.ResponseKota
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser


object JsonRepository {
    private lateinit var responseKota: ResponseKota
    private lateinit var responseAkomodasi: ResponseHotel
    fun getKota(context:Context): ResponseKota {
        val jsonFileString = getJsonDataFromAsset(context, Constant.JSONKOTA)
        val parser = JsonParser()
        val mJson: JsonElement = parser.parse(jsonFileString)
        val gson = Gson()
        responseKota = gson.fromJson(mJson, ResponseKota::class.java)
        return responseKota
    }
    fun getAkomodasi(context: Context): ResponseHotel {
        val jsonFileString = getJsonDataFromAsset(context, Constant.JSONAKOMODASI)
        val parser = JsonParser()
        val mJson: JsonElement = parser.parse(jsonFileString)
        val gson = Gson()
        responseAkomodasi = gson.fromJson(mJson, ResponseHotel::class.java)
        return responseAkomodasi
    }
}