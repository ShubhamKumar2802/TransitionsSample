package com.example.gridviewsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_new.*
import kotlinx.android.synthetic.main.event_grid_layout.*
import java.io.Serializable
import java.util.logging.Logger.global

class EventInfo(title: String, date: String) : Serializable {
    var title = ""
    var date = ""

    init {
        this.date = date
        this.title = title
    }
}

class MainActivity : AppCompatActivity() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var viewAdapter: RecyclerView.Adapter<*>
//    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = "Main Activity"

        val eventList: ArrayList<EventInfo> = arrayListOf(
            EventInfo("CS", "1"),
            EventInfo("RAS", "2"),
            EventInfo("IAS", "3")
        )


//        val gridView: GridView = findViewById(R.id.gvMain)
//        val adapter = EventAdapter(this, R.layout.event_grid_layout, eventList)


//        recyclerView = findViewById(R.id.rvMain)
////        viewAdapter = RecyclerViewAdapter(eventList)
////        viewManager = GridLayoutManager(this, 3)
////
////        recyclerView.adapter = viewAdapter

        val rvMain: RecyclerView = findViewById(R.id.rvMain)
        val adapter = RecyclerViewAdapter(eventList, MainActivity())
        mainActivity = this
        rvMain.layoutManager = GridLayoutManager(this, 2)
        rvMain.adapter = adapter

//        Log.d(TAG, "Before onClickListener")
//        gvMain.setOnItemClickListener { parent, view, position, id ->
//            Log.e(TAG, "inside OnClickListener: ${eventList[position].title}")
//            val intent = Intent(this, NewActivity::class.java)
//            intent.putExtra("Title", eventList[position].title)
//            intent.putExtra("EventDate", eventList[position].date)
//            startActivity(intent)
//        }
////
//        Log.d(TAG, "After onCLickListener")

//        val sceneRoot: ViewGroup = findViewById(R.id.sceneRoot)
//        val secondScene: Scene =
//            Scene.getSceneForLayout(sceneRoot, R.layout.activity_second_layout, this)
//
//        var fadeTransition: Transition =
//            TransitionInflater.from(this).inflateTransition(R.transition.fade_transition)
//
//        TransitionManager.go(secondScene, fadeTransition)


//        fun setSingleEvent(gridView: GridView) {
//
//            for (i in 1..gridView.childCount) {
//                Log.d(TAG, "setSignleEvent: Loop $i")
//                var cardView: CardView = gridView.getChildAt(i) as CardView
//
//                cardView.setOnClickListener {
//                    val newIntent = Intent(this, NewActivity::class.java)
//                    var options = ActivityOptions.makeSceneTransitionAnimation(
//                        this,
//                        Pair.create(cardView.tvTitle, "titleTransition")
//                    )
//                    startActivity(newIntent, options.toBundle())
//                }
//
//            }
//        }
//
//        setSingleEvent(gvMain)
//        gvMain.adapter = adapter
//
//        buttonTransition.setOnClickListener {
//            val intent = Intent(this, NewActivity::class.java)
//            startActivity(intent)
//        }
        
    }
}
