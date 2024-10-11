package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysapp.model.Day

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val days = createDays()
        val adapter = DayAdapter(days)
        recyclerView.adapter = adapter
    }

    private fun createDays(): List<Day> {
        // Create and return a list of 30 Day objects
        return (1..30).map { dayNumber ->
            Day(
                dayNumber = dayNumber,
                dayTitle = "Title for Day $dayNumber",
                dayDescription = "Description for Day $dayNumber",
                dayImage = R.drawable.bmo_code // Replace with actual image resources
            )
        }
    }
}