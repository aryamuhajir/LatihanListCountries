package com.binar.latihanlistcountries.Network

import com.binar.latihanlistcountries.Model.GetAllCountry
import com.binar.latihanlistcountries.Model.GetAllCountryItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/all")
    fun getAllCountries() : Call<List<GetAllCountryItem>>


}