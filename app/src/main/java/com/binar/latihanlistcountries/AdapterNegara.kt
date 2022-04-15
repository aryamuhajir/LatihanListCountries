package com.binar.latihanlistcountries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.latihanlistcountries.Model.GetAllCountryItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_adapter.view.*

class AdapterNegara(private var dataNegara : List<GetAllCountryItem>) : RecyclerView.Adapter<AdapterNegara.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNegara.ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: AdapterNegara.ViewHolder, position: Int) {




        holder.itemView.namaNegara.text = dataNegara[position].name.toString()
        holder.itemView.regionNegara.text = dataNegara[position].region.toString()
        holder.itemView.capitalNegara.text = dataNegara[position].capital


        Glide.with(holder.itemView.context).load(dataNegara[position].flags.png).into(holder.itemView.gambar_bendera)



    }

    override fun getItemCount(): Int {
        return dataNegara.size
    }
}