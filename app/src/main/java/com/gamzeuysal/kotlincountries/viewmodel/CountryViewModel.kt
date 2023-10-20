package com.gamzeuysal.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gamzeuysal.kotlincountries.model.Country

class CountryViewModel : ViewModel(){
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        //RoomDatabase'den veri okuyormusum gibi bir dummy Country objesi olusturalım
        var country = Country("Turkey","Asia","Ankara","TRY","Turkish","www.ss.com")
        //countryLiveData'yı dolduralım
        countryLiveData.value = country
    }
}