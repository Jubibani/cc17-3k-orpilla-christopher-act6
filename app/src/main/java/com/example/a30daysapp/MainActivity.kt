package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysapp.model.Day
import utilities.DayDataLoader

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dayAdapter: DayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create a static list of days
        val days = listOf(
            Day(1, "Procrastination", R.drawable.bmo_code.toString(),"Too lazy to write description...",

            ),
            Day(2, "Getting back up",    R.drawable.bmo_code.toString(),"Getting back on my grind from procrastination",
            ),
            // Add more days...
        )

        // Set up the adapter
        dayAdapter = DayAdapter(days)
        recyclerView.adapter = dayAdapter

    }
}
