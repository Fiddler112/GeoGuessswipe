package com.example.jonat.geoguessswipe

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GeoObjectAdapter(private val context: Context, var listGeoObject: List<GeoObject>) : RecyclerView.Adapter<GeoObjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeoObjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_cell, parent, false)
        return GeoObjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: GeoObjectViewHolder, position: Int) {
        // Gets a single item in the list from its position
        val geoObject = listGeoObject[position]
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.geoImage.setImageResource(geoObject.getmGeoImageName())

    }

    override fun getItemCount(): Int {
        return listGeoObject.size
    }
}

