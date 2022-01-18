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

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoin(coinId)
            emit(Resource.Success<CoinDetail>(data = coin))
        } catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"An unexpected message occurred"))
        } catch (e: IOException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Couldn't reach server"))
        }
    }
}