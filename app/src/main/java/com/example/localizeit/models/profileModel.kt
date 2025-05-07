package com.example.localizeit.models



data class Profile(
    val name: String,
    val language: String,
    val location: String,
    val skills: List<String>, // These are your "courses"
    val profilePictureUrl: String? = null
)
