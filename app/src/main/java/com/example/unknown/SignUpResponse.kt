package com.example.unknown

data class SignUpResponse(
    val success: Boolean,
    val message: String,
    val user: User?
)
