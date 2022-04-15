package com.binar.latihanlistcountries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.latihanlistcountries.Model.GetAllCountry
import com.binar.latihanlistcountries.Model.GetAllCountryItem
import com.binar.latihanlistcountries.Network.APIClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataNegara()


    }
    fun getDataNegara(){
        APIClient.instance.getAllCountries()
            .enqueue(object : retrofit2.Callback<List<GetAllCountryItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountryItem>>,
                    response: Response<List<GetAllCountryItem>>
                ) {
                    if (response.isSuccessful){
                        val dataNegara = response.body()
                        val adapterNegara = AdapterNegara(dataNegara!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_item.layoutManager = lm
                        rv_item.adapter = adapterNegara
                    }else{
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllCountryItem>>, t: Throwable) {

                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}