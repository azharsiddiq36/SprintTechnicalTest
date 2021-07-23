package com.example.sprinttechnicaltest.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.sprinttechnicaltest.R

object PictureLib {
    fun loadPicture(context: Context, url: String?, ivImage: ImageView){
        Glide.with(context)
            .load(url)
            .centerInside()
            .thumbnail(0.25f)
            .error(R.drawable.ic_launcher_background)
            .into(ivImage)
    }
}