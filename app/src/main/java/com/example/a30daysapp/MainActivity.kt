package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a30daysapp.model.Day
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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
        val json = assets.open("days.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val type = object : TypeToken<List<Day>>() {}.type
        return gson.fromJson(json, type)
    }
}