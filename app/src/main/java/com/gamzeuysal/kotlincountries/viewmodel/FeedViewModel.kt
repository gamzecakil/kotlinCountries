package com.gamzeuysal.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gamzeuysal.kotlincountries.model.Country

class FeedViewModel : ViewModel() {

    val countries = MutableLiveData<ArrayList<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        //verileri database ya da API aldıgımız fonksiyon
        //Burada öncelikle dumy datalar ile çalışalım
        val country = Country("Turkey", "Asia", "Ankara", "TRY", "Turkish", "www.ss.com")
        val country2 = Country("France", "Europe", "Paris", "Euro", "French", "www.ss.com")
        val country3 = Country("Germany", "Europe", "Berlin", "Euro", "German", "www.ss.com")

        val countryList = arrayListOf<Country>(country, country2, country3)

        //List<Country> isteyen MutableLiveData 'yı dolduralım.
        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }
}