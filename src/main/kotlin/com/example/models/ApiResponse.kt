package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null, // needed for paging 3 library for pagination
    val nextPage: Int? = null, // needed for paging 3 library for pagination
    val heroes: List<Hero> = emptyList(),
    val lastUpdated: Long? = null
)
