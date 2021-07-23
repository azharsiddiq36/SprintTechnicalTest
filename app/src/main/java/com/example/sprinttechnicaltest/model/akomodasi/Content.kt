package com.example.sprinttechnicaltest.model.akomodasi

class Content(val ticketID: String,
              val type: String?,
              val referenceImage: String? = null,
              val referenceID: String,
              val referenceName: String,
              val ticketName: String,
              val description: String,
              val validities: String,
              val isRecomended: Long,
              val noted: String,
              val value: List<String>,
              val duration: String,
              val validateTime: String,
              val validityInformation: String,
              val termAndCondition: String,
              val reservationInformation: String,
              val cancelationPolicy: String,
              val redemptionInformation: String) {
}