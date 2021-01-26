package com.kyodude.currencyconverter.main

import androidx.hilt.lifecycle.ViewModelInject
import com.kyodude.currencyconverter.util.DispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val dispatcher: DispatcherProvider
) {
    sealed class CurrencyEvent {
        class Success(val resultText: String): CurrencyEvent()
        class Error(val errorText: String): CurrencyEvent()
        object Loading : CurrencyEvent()
        object Empty : CurrencyEvent()
    }

    private val _conversion = MutableStateFlow<CurrencyEvent> (CurrencyEvent.Empty)
    val conversion: StateFlow<CurrencyEvent> = _conversion

    fun convert(
        amountStr: String,
        fromCurrency: String,
        toCurrency: String
    ){
        val fromAmount = amountStr.toFloatOrNull()
        if(fromAmount==null)
        {
            _conversion.value = CurrencyEvent.Loading
//            when(val rateResponse = repository.getRates(fromCurrency))
        }
    }
}