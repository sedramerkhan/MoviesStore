package com.example.moviesstore.model

data class Detail(
    val actors: List<Actor>,
    val category_id: Int,
    val director: String,
    val id: Int,
    val rating: Double,
    val summary: String,
    val title: String,
    val writers: List<String>,
    val year: String,
    val youtube_video_id: String
)