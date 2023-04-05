package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero

interface HeroRepositoryAlternative {

    val heroes: List<Hero>

    suspend fun getAllHeroes(page: Int = 1, limit: Int = 4): ApiResponse  // fun to get the heroes and paginate it which will return the api response

    suspend fun searchHeroes(name: String?): ApiResponse // fun to search the heroes in the client side
}