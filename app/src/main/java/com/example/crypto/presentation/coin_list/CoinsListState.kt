package com.example.crypto.presentation.coin_list

import com.example.crypto.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)
