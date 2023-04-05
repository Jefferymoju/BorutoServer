package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero

interface HeroRepository {

    val heroes: Map<Int, List<Hero>> // val to easily map our server response

    // list of page val for pagination
    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>

    suspend fun getAllHeroes(page: Int = 1): ApiResponse  // fun to get the heroes and paginate it which will return the api response

    suspend fun searchHeroes(name: String?): ApiResponse // fun to search the heroes in the client side
}