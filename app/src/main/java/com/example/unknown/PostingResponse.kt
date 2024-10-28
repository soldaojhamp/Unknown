package com.example.unknown

data class PostingResponse(
    val success: Boolean,
    val message: String?,
    val post: PostingResponse?
)