package com.gamzeuysal.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gamzeuysal.kotlincountries.R


class CountryFragment : Fragment() {

    private var countryUuid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    //Counrty Fagment arguman ekledik
    //Feed Fragmentan  seçilen item'ın  id'sini alalım.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            //arada sınıfların oluşması için rebuild yapalım.
            countryUuid  = CountryFragmentArgs.fromBundle(it).countryUuid
        }
    }
}