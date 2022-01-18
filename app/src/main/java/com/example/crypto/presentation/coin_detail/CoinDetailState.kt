package com.example.crypto.presentation.coin_detail

import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = "",
)
