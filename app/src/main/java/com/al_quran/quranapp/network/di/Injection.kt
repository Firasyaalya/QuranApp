package com.al_quran.quranapp.network.di

import android.content.Context
import com.al_quran.quranapp.local.CalendarPreferences
import com.al_quran.quranapp.local.LocationPrefrences
import com.al_quran.quranapp.network.ApiConfig
import com.al_quran.quranapp.network.RemoteDataSource
import com.al_quran.quranapp.network.adzan.AdzanRepository
import com.al_quran.quranapp.network.quran.QuranRepository

object Injection {
        val quranApiService = ApiConfig.getQuranService
        val adzanApiService = ApiConfig.getAdzanTimeService
        val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
        fun provideQuranRepository(): QuranRepository {
        return QuranRepository(remoteDataSource)
    }

    fun provideAdzanRepository(context: Context): AdzanRepository {
        val locationPrefrences = LocationPrefrences(context)
        val calendarPrefrences = CalendarPreferences()
        return AdzanRepository(remoteDataSource, locationPrefrences, calendarPrefrences)
    }
}