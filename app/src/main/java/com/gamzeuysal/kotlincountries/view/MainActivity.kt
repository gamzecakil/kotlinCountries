package com.gamzeuysal.kotlincountries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gamzeuysal.kotlincountries.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Json
       // https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    }
}