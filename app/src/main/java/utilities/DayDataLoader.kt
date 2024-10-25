package utilities

import android.content.Context
import com.example.a30daysapp.model.Day
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

object DayDataLoader {

    // Function to load JSON data from the assets folder
    fun loadDaysFromJson(context: Context): List<Day> {
        val inputStream = context.assets.open("days.json") // Open the file
        val reader = InputStreamReader(inputStream)        // Read the file
        val gson = Gson()                                  // Create a Gson object

        // Create a type token for a list of Day objects
        val type = object : TypeToken<List<Day>>() {}.type

        // Parse the JSON into a list of Day objects
        return gson.fromJson(reader, type)
    }
}