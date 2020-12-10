package com.muzaaz.travelokaapps.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.muzaaz.travelokaapps.R
import com.muzaaz.travelokaapps.data.DataHeader
import kotlinx.android.synthetic.main.item_header.view.*

class AdapterHeader (private val dataHeaders : List<DataHeader>)
    : RecyclerView.Adapter<AdapterHeader.HeaderViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataHeaders.size
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(dataHeaders[position])
    }

    inner class HeaderViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val headerImage = view.findViewById<ImageView>(R.id.item_image_header)

        fun bind (dataHeader: DataHeader) {
            headerImage.setImageResource(dataHeader.imageHeader)
        }
    }

}