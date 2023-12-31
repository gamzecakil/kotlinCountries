package com.gamzeuysal.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gamzeuysal.kotlincountries.R
import com.gamzeuysal.kotlincountries.model.Country
import com.gamzeuysal.kotlincountries.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {

    private lateinit var  viewModel : CountryViewModel
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

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        //view model dolduralım
        viewModel.getDataFromRoom()

        arguments?.let {
            //arada sınıfların oluşması için rebuild yapalım.
            countryUuid  = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        observeLiveData()
    }

    private fun observeLiveData(){
      viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {  country ->
          country?.let {
              countryName.text = country.countryName
              countryCapital.text = country.countryCapital
              countryRegion.text = country.countryRegion
              countryCurrency.text = country.countryCurrency
              countryLanguage.text = country.countryLanguage
          }
      })
    }
}