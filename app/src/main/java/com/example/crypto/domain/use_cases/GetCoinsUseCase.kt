package com.example.crypto.domain.use_cases

import com.example.crypto.common.Resource
import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.model.CoinDetail
import com.example.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(data = coins))
        } catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"An unexpected message occurred"))
        } catch (e: IOException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"Couldn't reach server"))
        }
    }
}