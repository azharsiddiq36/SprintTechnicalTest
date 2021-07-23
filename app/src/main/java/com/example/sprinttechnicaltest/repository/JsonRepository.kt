package com.example.sprinttechnicaltest.repository

import android.content.Context
import android.util.Log
import com.example.rdiandroiddevelopertest.enum.Constant
import com.example.sprinttechnicaltest.model.akomodasi.Response
import com.example.sprinttechnicaltest.model.kota.ResponseKota
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken


object JsonRepository {
    private lateinit var responseKota:ResponseKota
    private lateinit var responseAkomodasi: Response
    fun getKota(context:Context): ResponseKota {
        val jsonFileString = getJsonDataFromAsset(context, Constant.JSONKOTA)
        Log.i("kentang 16", jsonFileString.toString())
        val parser = JsonParser()
        val mJson: JsonElement = parser.parse(jsonFileString)
        val gson = Gson()
        responseKota = gson.fromJson(mJson, ResponseKota::class.java)
        return responseKota
    }
    fun getAkomodasi(context: Context): Response {
        val jsonFileString = getJsonDataFromAsset(context, Constant.JSONAKOMODASI)
        val parser = JsonParser()
        val mJson: JsonElement = parser.parse(jsonFileString)
        val gson = Gson()
        responseAkomodasi = gson.fromJson(mJson, Response::class.java)
        return responseAkomodasi
    }
}