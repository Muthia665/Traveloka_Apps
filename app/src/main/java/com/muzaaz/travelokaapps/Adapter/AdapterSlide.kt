package com.muzaaz.travelokaapps.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muzaaz.travelokaapps.R
import com.muzaaz.travelokaapps.data.DataSlide


class AdapterSlide(private val dataSlides : List<DataSlide>) :
    RecyclerView.Adapter<AdapterSlide.SliderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.slide_item,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataSlides.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(dataSlides[position])
    }


    inner class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.item_title)
        private val textDescription = view.findViewById<TextView>(R.id.item_description)
        private val imagePicture = view.findViewById<ImageView>(R.id.item_image)

        fun bind (dataSlide: DataSlide){
            textTitle.text = dataSlide.title
            textDescription.text = dataSlide.desc
            imagePicture.setImageResource(dataSlide.image)
        }
    }
}