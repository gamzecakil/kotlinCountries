package com.gamzeuysal.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gamzeuysal.kotlincountries.R
import com.gamzeuysal.kotlincountries.adapter.CountryAdapter
import com.gamzeuysal.kotlincountries.model.Country
import com.gamzeuysal.kotlincountries.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

  private lateinit var viewModel : FeedViewModel
  private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view model initialize
        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        //view modela verileri yükleyelim
        viewModel.refreshData()
        //recyclerView da gösterelim
        recyclerViewCountryList.layoutManager = LinearLayoutManager(context)
        recyclerViewCountryList.adapter = countryAdapter//surada adapterdaki list  bostu observeLiveData daki    notifyDataSetChanged() ile adapter daki listi guncelledik.

        //MutableLiveData ile verilerde değişiklilik var mı gözlemleyelim.
        observeLiveData()
/*
        fragment_button.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }

 */
    }
   private fun observeLiveData(){
      viewModel.countries.observe(viewLifecycleOwner, Observer {  countries ->
          countries?.let {
              //recylerView göster progressbar ve error messajı kapat
              recyclerViewCountryList.visibility = View.VISIBLE
              countryAdapter.updateCountryList(countries)
          }
      })

        viewModel.countryError.observe(viewLifecycleOwner, Observer {  error ->
            error?.let {
               if(error)
               {
                   //hata varsa
                   textCountryError.visibility = View.VISIBLE
               }else{
                   textCountryError.visibility = View.GONE
               }
            }
        })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer {  loading ->

            loading?.let {
                if(loading)
                {
                    // veriler yükleniyorken progressbar  gözükürken recylerview ve hata mesajının gözükmemesi gerekir.
                    progressBarCountryLoading.visibility = View.VISIBLE
                    recyclerViewCountryList.visibility = View.GONE
                    textCountryError.visibility = View.GONE

                }else{
                    progressBarCountryLoading.visibility = View.GONE
                }
            }
        })
    }



}