package com.al_quran.quranapp.network.adzan

import retrofit2.http.GET
import retrofit2.http.Path

interface AdzanApiService {
    @GET("sholat/kota/cari/{city}")
    suspend fun searchCity(
        @Path("city") City: String
    ) : CityResponse

    @GET("sholat/jadwaL/{id}/{year}/{month}/{date}")
    suspend fun getDailyAdzanTime(
        @Path("id") id: String,
        @Path("year") year: String,
        @Path("month") month: String,
        @Path("date") date: String
    ): DailyResponse
}