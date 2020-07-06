package com.example.gridviewsample

import android.content.Intent
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
//import android.util.Pair
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.core.util.Pair

lateinit var mainActivity: MainActivity

class SharedElement(val view: View, val title: String) {
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvTitle: TextView = v.findViewById(R.id.tvTitle)
    val tvDate: TextView = v.findViewById(R.id.tvDate)
    val cvMain: CardView = v.findViewById(R.id.cardView_id)
}

class RecyclerViewAdapter(val dataSet: ArrayList<EventInfo>, activity: MainActivity) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        view =
            LayoutInflater.from(parent.context).inflate(R.layout.event_grid_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitle.text = dataSet[position].title
        holder.tvDate.text = dataSet[position].date

        holder.cvMain.setOnClickListener {

            val tvTitleNew: TextView = it.findViewById(R.id.tvTitle)
            val tvDateNew: TextView = it.findViewById(R.id.tvDate)

            val intent = Intent(it.context, NewActivity::class.java)
            intent.putExtra("Title", dataSet[position].title)
            intent.putExtra("Date", dataSet[position].date)


//            val titlePairView = Pair(tvTitleNew, "titleTransition")
//            val datePairView = Pair(tvDateNew, "eventTransition")

            val titlePairView = Pair.create<View, String>(tvTitleNew, "titleTransition")
            val datePairView = Pair.create<View, String>(tvDateNew, "eventTransition")

//            val mainActivity = MainActivity()


//            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                mainActivity,
//                tvTitleNew,
//                ViewCompat.getTransitionName(tvTitleNew)!!
//            )

            val fade = Fade()
            fade.excludeTarget(android.R.id.statusBarBackground, true)
            fade.excludeTarget(android.R.id.navigationBarBackground, true)
            

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                mainActivity,
                Pair.create<View, String>(tvTitleNew, "titleTransition"),
                Pair.create<View, String>(tvDateNew, "eventTransition")
            )

            startActivity(it.context, intent, options.toBundle())
//            startActivity(it.context, intent, null)

        }
    }
}