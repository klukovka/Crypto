package com.example.crypto.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.Resource
import com.example.crypto.domain.use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel(){

    private val _state = mutableStateOf(CoinsListState())
    val state : State<CoinsListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinsListState(coins = result.data
                        ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinsListState(error = result.message
                        ?: "An unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
