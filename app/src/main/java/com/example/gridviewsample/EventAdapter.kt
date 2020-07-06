package com.example.gridviewsample

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity

class EventHolder(v: View) {
    val tvTitle: TextView = v.findViewById(R.id.tvTitle)
    val tvEventDate: TextView = v.findViewById(R.id.tvDate)
}

class EventAdapter(context: Context, val resource: Int, val eventList: ArrayList<EventInfo>) :
    ArrayAdapter<EventInfo>(context, resource, eventList) {
    val TAG = "EventAdapter"

    override fun getCount(): Int {
        return eventList.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: EventHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resource, null)
            viewHolder = EventHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as EventHolder
        }

        val currentEvent = eventList[position]

        viewHolder.tvTitle.text = currentEvent.title
        viewHolder.tvEventDate.text = currentEvent.date

//        view.setOnClickListener {
//            val intent = Intent(this.context, NewActivity::class.java).apply {
//                putExtra("Title", currentEvent.title)
//                putExtra("EventDate", currentEvent.date)
//            }
//
////            val activity: MainActivity = MainActivity()
////
//////            ActivityOptionsCompat.makeClipRevealAnimation(it.rootView, 100, 0, R.layout.activity_new, R.layout.activity_new)
////            val transition = ViewCompat.getTransitionName(view)?.let { it1 ->
////                ActivityOptionsCompat.makeSceneTransitionAnimation(
////                    activity,
////                    view,
////                    it1
////                )
////            }
////            if (transition != null) {
////                startActivity(it.context, intent, transition.toBundle())
////            }
//
//            startActivity(it.context, intent, null)
//        }

//        view.setOnClickListener {
//            val newIntent = Intent(this.context, NewActivity::class.java)
//            newIntent.putExtra("Title", currentEvent.title)
//            newIntent.putExtra("EventDate", currentEvent.date)
//
//            val mainActivity: MainActivity = MainActivity()
////            val pairs: Array
////            pairs[0] = Pair<View, String>()
//
//
//            var options = ActivityOptions.makeSceneTransitionAnimation(mainActivity,
//                    Pair.create(viewHolder.tvTitle, "titleTransition")
//            )
//
//            startActivity(it.context, newIntent, options.toBundle())
//        }

        try {
            val mainActivity = MainActivity()

            view.setOnClickListener {
                val intent = Intent(this.context, NewActivity::class.java).apply {
                    putExtra("Title", currentEvent.title)
                    putExtra("EventDate", currentEvent.date)
                }
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mainActivity,
                    viewHolder.tvTitle as View,
                    "titleTransition"
                )
                startActivity(it.context, intent, null)
            }
        } catch (e: Exception) {
            Log.e(TAG, "exception: ${e.message}")
        }

        return view
    }
}