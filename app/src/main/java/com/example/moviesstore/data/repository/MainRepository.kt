package com.example.moviesstore.data.repository

import com.example.moviesstore.data.files.getData
import com.example.moviesstore.model.Category
import com.example.moviesstore.model.Movie
import com.example.moviesstore.presentation.BaseApplication
import com.google.gson.reflect.TypeToken
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val application: BaseApplication,
) {

    fun getCategories(): List<Category> = application.getData(
        "categories.json",
        object : TypeToken<List<Category>>() {}.type
    ) as List<Category>

     fun getMoviesList() =
        application.getData(
            "details.json",
            object : TypeToken<List<Movie>>() {}.type
        ) as List<Movie>

    fun getMovie(id:Int): Movie {
        val movie= application.getData(
        "details.json",
        object : TypeToken<List<Movie>>() {}.type
        ) as List<Movie>

        return movie.first { it.id ==id }
    }
}