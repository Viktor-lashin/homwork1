package com.lection.homework1

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


class MainAdapter() : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val items : ArrayList<Quadrate> = ArrayList()

    fun add(quadrate: Quadrate){
        items.add(quadrate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_quadrate, null)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tv : TextView = itemView.findViewById(R.id.quadrat)
        fun bind(quadrate: Quadrate){
            tv.text = quadrate.num.toString()
            if(quadrate.num % 2 == 0)
                tv.background = ContextCompat.getColor(itemView.context, R.color.red).toDrawable()
            else
                tv.background =  ContextCompat.getColor(itemView.context, R.color.blue).toDrawable()
        }
    }
}