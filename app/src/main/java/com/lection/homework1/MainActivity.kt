package com.lection.homework1

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rv : RecyclerView
    lateinit var adapter : MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.activity_main_rv)
        var now = 0
        adapter = MainAdapter()
        rv.adapter = adapter
        val ll : LinearLayout = findViewById(R.id.linear_layout)
        val layoutParams = rv.layoutParams as LinearLayout.LayoutParams
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.LANDSCAPE_ITEMS_COUNT))
            layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT
            layoutParams.width = 0
            ll.orientation = LinearLayout.HORIZONTAL
        } else {
            rv.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.PORTRAIT_ITEMS_COUNT))
            layoutParams.height = 0
            layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
            ll.orientation = LinearLayout.VERTICAL
        }
        rv.layoutParams = layoutParams
        val fab : FloatingActionButton = findViewById(R.id.button_add)
        savedInstanceState?.let {
            for(i in 0 until it.getInt("size")){
                adapter.add(Quadrate(now))
                now += 1
            }
        }
        fab.setOnClickListener {
            adapter.add(Quadrate(now))
            now += 1
            adapter.notifyItemChanged(adapter.itemCount - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("size", adapter.itemCount)
    }
}
