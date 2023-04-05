package com.example.routes

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes(){
    val heroRepository: HeroRepository by inject() // inject the HeroRepositoryImpl in the function

    get("/boruto/heroes"){
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1 // if a client don't pass any parameter for a page query
            // then we want to set a default value of the page to 1. That means the page we want to send to our client will be page number 1
            require(page in 1..5) // we only need the query parameter to be either 1,2,3,4 or 5 since our api will provide data for 5 pages

            val apiResponse = heroRepository.getAllHeroes(page = page)
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
                )

        }catch (e: NumberFormatException){
           call.respond(
               message = ApiResponse(success = false, message = "Only Numbers Allowed."),
               status = HttpStatusCode.BadRequest
           )
        }catch (e: IllegalArgumentException){
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not found."),
                status = HttpStatusCode.NotFound
            )
        }
    }
}