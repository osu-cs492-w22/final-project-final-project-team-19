package com.example.honorscollegeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.honorscollegeapp.R
import com.example.honorscollegeapp.data.*


class CalendarAdapter(private val onClick: (CalendarEvent) -> Unit)
    : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    var calendarEvents: List<CalendarEvent> = listOf()

    fun updateForecast(events: Calendar?) {
        calendarEvents = events?.items ?: listOf()
        notifyDataSetChanged()
    }

    override fun getItemCount() = this.calendarEvents.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_card, parent, false) //event_list_item xml needs to be created
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.calendarEvents[position])
    }


    class ViewHolder(itemView: View, val onClick: (CalendarEvent) -> Unit)
        : RecyclerView.ViewHolder(itemView) {

        /*
        Insert xml data-holder references here:

        private val dateTV: TextView = itemView.findViewById(R.id.tv_date)
        */

        private var currentEvent: CalendarEvent? = null

        init {
            itemView.setOnClickListener {
                currentEvent?.let(onClick)
            }
        }

        fun bind(calendarEvent: CalendarEvent) {
            currentEvent = calendarEvent

            val ctx = itemView.context

            /*
            Insert data into viewholder objects here:

            dateTV.text = ctx.getString(R.string.forecast_date, date)
            */
        }
    }
}