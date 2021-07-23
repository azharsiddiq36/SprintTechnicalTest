package com.example.sprinttechnicaltest.model


class ResponseHotel(val status: Boolean,
                    val data: DataHotel,
                    val message: String,
                    val code: Long) {
}