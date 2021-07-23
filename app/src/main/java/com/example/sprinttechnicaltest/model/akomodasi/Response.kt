package com.example.sprinttechnicaltest.model.akomodasi

import com.example.sprinttechnicaltest.model.akomodasi.Data


class Response(val status: Boolean,
               val data: Data,
               val message: String,
               val code: Long) {
}