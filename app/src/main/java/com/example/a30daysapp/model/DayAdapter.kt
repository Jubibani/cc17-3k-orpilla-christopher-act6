package com.example.a30daysapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
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
        holder.dayDescriptionTextView.text = day.dayDescription
        holder.dayTitleTextView.text = day.dayTitle


        // Get the resource ID by name, or null if it doesn't exist
        val resourceId = holder.dayImageView.context.resources.getIdentifier(
            day.dayImageResId, "drawable", holder.dayImageView.context.packageName
        )

        if (resourceId != 0) { // Valid resource ID
            holder.dayImageView.setImageDrawable(
                AppCompatResources.getDrawable(holder.dayImageView.context, resourceId)
            )
        } else {
            // Set a default or placeholder image if the resource doesn't exist
            holder.dayImageView.setImageResource(R.drawable.bmo_code) // Replace with your placeholder drawable
        }
    }


    override fun getItemCount() = days.size
}