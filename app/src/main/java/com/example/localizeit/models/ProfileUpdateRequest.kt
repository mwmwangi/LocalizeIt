package com.example.localizeit.models



data class ProfileUpdateRequest(
    val name: String,
    val language: String,
    val location: String,
    val skills: List<String>
)
