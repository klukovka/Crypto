package com.example.crypto.data.repository

import com.example.crypto.data.dto.toCoin
import com.example.crypto.data.dto.toCoinDetail
import com.example.crypto.data.remote.CoinPaprikaApi
import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.model.CoinDetail
import com.example.crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoin(coinId: String): CoinDetail {
        return api.getCoinById(coinId = coinId).toCoinDetail()
    }
}
