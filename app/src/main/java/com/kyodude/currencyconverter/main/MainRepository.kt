package com.kyodude.currencyconverter.main

import com.kyodude.currencyconverter.data.models.CurrencyResponse
import com.kyodude.currencyconverter.util.Resource

interface MainRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}