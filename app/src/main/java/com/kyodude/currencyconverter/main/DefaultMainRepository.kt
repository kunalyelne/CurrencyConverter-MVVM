package com.kyodude.currencyconverter.main

import com.kyodude.currencyconverter.data.CurrencyAPI
import com.kyodude.currencyconverter.data.models.CurrencyResponse
import com.kyodude.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyAPI
): MainRepository {
    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(base)
            val result = response.body()
            if(response.isSuccessful && result != null)
            {
                Resource.Success(result)
            }
            else{
                Resource.Error(response.message())
            }
        }
        catch (e: Exception){
            Resource.Error(e.message?: "An error occured")
        }
    }
}