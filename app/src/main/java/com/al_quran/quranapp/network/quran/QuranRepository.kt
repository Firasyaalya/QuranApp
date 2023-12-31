package com.al_quran.quranapp.network.quran

import com.al_quran.quranapp.network.NetworkBoundResource
import com.al_quran.quranapp.network.NetworkResponse
import com.al_quran.quranapp.network.RemoteDataSource
import com.al_quran.quranapp.network.Resource
import com.al_quran.quranapp.utils.DataMapper
import kotlinx.coroutines.flow.Flow

class QuranRepository(private val remoteDataSource: RemoteDataSource) : IQuranRepository {
    override fun getListSurah(): Flow<Resource<List<Surah>>> {
        return object : NetworkBoundResource<List<Surah>, List<SurahItem>>(){
            override fun fetchFromNetwork(data: List<SurahItem>): Flow<List<Surah>> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<NetworkResponse<List<SurahItem>>> {
                return remoteDataSource.getListSurah()
            }
        }.asFlow()
    }

    override fun getDetailSurahWithQuranEditions(number: Int): Flow<Resource<List<QuranEdition>>> {
        return object : NetworkBoundResource<List<QuranEdition>, List<QuranEditionItem>>(){
            override fun fetchFromNetwork(data: List<QuranEditionItem>): Flow<List<QuranEdition>> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<NetworkResponse<List<QuranEditionItem>>> {
                return remoteDataSource.getDetailSurahWithQuranEditions(number)
            }

        }.asFlow()
    }
}