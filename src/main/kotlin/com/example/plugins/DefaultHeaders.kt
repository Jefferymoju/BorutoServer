package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*

fun Application.configureDefaultHeader() {
   install(DefaultHeaders){
       val oneYearInSeconds = java.time.Duration.ofDays(365).seconds  // get the seconds from 365 days
       // needed to specify how long we want to catch the data we send from the server
       header(name = HttpHeaders.CacheControl,
           value = "public, max-age=$oneYearInSeconds, immutable"
       )// with this we can configure our server to send this custom header
   // with each response we send to our client
   }
}