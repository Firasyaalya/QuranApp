package com.al_quran.quranapp.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.al_quran.quranapp.network.Resource
import com.al_quran.quranapp.network.adzan.AdzanDataResult
import com.al_quran.quranapp.network.adzan.AdzanRepository

class AdzanViewModel (
    private val adzanRepository: AdzanRepository
): ViewModel(){
    fun getDailyAdzanTime():
            LiveData<Resource<AdzanDataResult>> = adzanRepository
        .getResultDailyAdzantime()
}