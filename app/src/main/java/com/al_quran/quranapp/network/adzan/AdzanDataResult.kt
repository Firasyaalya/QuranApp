package com.al_quran.quranapp.network.adzan

import com.al_quran.quranapp.network.Resource
import java.util.Calendar

data class AdzanDataResult(
    val listLocation: List<String>,
    val dailyAdzan: Resource<DailyAdzan>,
    val listCalendar: List<String>
)
