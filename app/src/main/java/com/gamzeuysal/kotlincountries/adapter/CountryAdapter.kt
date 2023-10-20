package com.gamzeuysal.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gamzeuysal.kotlincountries.R
import com.gamzeuysal.kotlincountries.model.Country
import com.gamzeuysal.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

     class CountryViewHolder(var view : View) : RecyclerView.ViewHolder(view){

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.textName.text = countryList[position].countryName
        holder.view.textRegion.text = countryList[position].countryRegion
        holder.view.setOnClickListener {
            //diger fragmenta gecelim  --> Navigation
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList : ArrayList<Country>)
    {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged() //adapter'a verinin değiştiğini bildirmek için kullanıyoruz
    }
}