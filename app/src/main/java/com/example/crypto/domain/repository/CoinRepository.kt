package com.example.crypto.domain.repository

import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>

    suspend fun getCoin(coinId: String): CoinDetail
}