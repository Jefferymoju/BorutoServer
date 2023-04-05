package com.example.di

import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryAlternative
import com.example.repository.HeroRepositoryImpl
import com.example.repository.HeroRepositoryImplAlternative
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {// single function of type HeroRepository
        HeroRepositoryImpl()
    }
    single<HeroRepositoryAlternative> {// single function of type HeroRepositoryAlternative
        HeroRepositoryImplAlternative()
    }
}