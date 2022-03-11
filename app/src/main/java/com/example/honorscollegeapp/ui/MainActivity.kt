package com.example.honorscollegeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.honorscollegeapp.BuildConfig
import com.example.honorscollegeapp.R

/*
 * To use your own OpenWeather API key, create a file called `gradle.properties` in your
 * GRADLE_USER_HOME directory (this will usually be `$HOME/.gradle/` in MacOS/Linux and
 * `$USER_HOME/.gradle/` in Windows), and add the following line:
 *
 *   OPENWEATHER_API_KEY="<put_your_own_OpenWeather_API_key_here>"
 *
 * The Gradle build for this project is configured to automatically grab that value and store
 * it in the field `BuildConfig.OPENWEATHER_API_KEY` that's used below.  You can read more
 * about this setup on the following pages:
 *
 *   https://developer.android.com/studio/build/gradle-tips#share-custom-fields-and-resource-values-with-your-app-code
 *
 *   https://docs.gradle.org/current/userguide/build_environment.html#sec:gradle_configuration_properties
 *
 * Alternatively, you can just hard-code your API key below 🤷‍.
 */
const val GOOGLE_API_KEY = "AIzaSyDjwke8tWWu_-CSsA7pev_G8OqTALsaAKs"

class MainActivity : AppCompatActivity() {
    private lateinit var requestQueue: RequestQueue
    private val apiBaseUrl = "https://www.googleapis.com/"
    private val calendarId = "dlme32b3csk7fjb1dpn9nhv5g8@group.calendar.google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(this)
        doCalendarSearch(this.calendarId)
    }

    private fun doCalendarSearch(calendarId: String){
        val url =
            "${apiBaseUrl}calendar/v3/calendars/${calendarId}/events?key=$GOOGLE_API_KEY"

        val req = StringRequest(
            Request.Method.GET,
            url,
            {
                Log.d("MainActivity", it)
            },
            {
                Log.d(
                    "MainActivity",
                    "Error fetching from $url: ${it.message}"
                )
            }
        )
        requestQueue.add(req);
    }
}