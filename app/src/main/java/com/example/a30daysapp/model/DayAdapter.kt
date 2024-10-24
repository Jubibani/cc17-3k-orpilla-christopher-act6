package com.example.a30daysapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysapp.model.Day

class DayAdapter(private val days: List<Day>) : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayNumberTextView: TextView = itemView.findViewById(R.id.dayNumberTextView)
        val dayTitleTextView: TextView = itemView.findViewById(R.id.dayTitleTextView)
        val dayDescriptionTextView: TextView = itemView.findViewById(R.id.dayDescriptionTextView)
        val dayImageView: ImageView = itemView.findViewById(R.id.dayImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = days[position]
        holder.dayNumberTextView.text = "Day ${day.dayNumber}"
        holder.dayTitleTextView.text = day.dayTitle
        holder.dayDescriptionTextView.text = day.dayDescription

        // Load image dynamically using getIdentifier()
        val imageResId = holder.itemView.context.resources.getIdentifier(
            day.dayImageResId.replace(".jpg", ""), "drawable", holder.itemView.context.packageName
        )

        if (imageResId != 0) { // Check if the resource ID is valid
            holder.dayImageView.setImageResource(imageResId)
        } else {
            // Handle the case where the image resource is not found
            holder.dayImageView.setImageResource(R.drawable.bmo_code) // Set a default image
        }
    }


    override fun getItemCount() = days.size
}