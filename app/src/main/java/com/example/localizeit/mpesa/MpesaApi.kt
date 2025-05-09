package com.example.localizeit.mpesa

//package com.example.localizeit.mpesa

import android.util.Log

object MpesaApi {
    fun initiatePayment(phone: String, amount: Double) {
        Log.d("MpesaApi", "Pretending to send KES $amount to $phone via M-Pesa API.")
        // This is a stub. Replace with Safaricom Daraja API integration if needed.
    }
}
