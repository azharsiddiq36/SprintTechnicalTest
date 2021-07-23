package com.example.sprinttechnicaltest.repository

import android.content.Context
import android.content.Intent
import com.example.rdiandroiddevelopertest.enum.Constant
import com.example.sprinttechnicaltest.MainActivity

object NavigatorRepository {
    fun openDetailKota(context: Context, genreId:String?){
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra(Constant.genreId,genreId)
        context.startActivity(intent)
    }
}