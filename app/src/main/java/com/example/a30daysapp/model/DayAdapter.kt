package com.example.a30daysapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysapp.model.Day

class DayAdapter(private val days: List<Day>) : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    // Define the ViewHolder
    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayNumberTextView: TextView = itemView.findViewById(R.id.dayNumberTextView)
        val dayTitleTextView: TextView = itemView.findViewById(R.id.dayTitleTextView)
        val dayDescriptionTextView: TextView = itemView.findViewById(R.id.dayDescriptionTextView)
        val dayImageView: ImageView = itemView.findViewById(R.id.dayImageView)
    }

    // Inflate the item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day, parent, false)
        return DayViewHolder(view)
    }

    // Bind the data to the ViewHolder
    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = days[position]
        holder.dayNumberTextView.text = "Day ${day.dayNumber}"
        holder.dayTitleTextView.text = day.dayTitle
        holder.dayDescriptionTextView.text = day.dayDescription
        holder.dayImageView.setImageResource(day.dayImage)
    }

    // Return the total count of items
    override fun getItemCount() = days.size
}