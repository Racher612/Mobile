package com.example.homework1done

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Rectangle(itemView : View) : RecyclerView.ViewHolder(itemView){
    var rectangle = itemView.findViewById<TextView>(R.id.RECTANGLE)
}

data class RectangleInfo(
    val color: Int,
    var number: Int
)

class CustomAdapter(private val names: List<RectangleInfo>) : RecyclerView.Adapter<Rectangle>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rectangle {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rectangle, parent, false)
        return Rectangle(itemView)
    }

    override fun onBindViewHolder(holder: Rectangle, position: Int) {
        holder.rectangle.setBackgroundResource(names[position].color)
        holder.rectangle.text = names[position].number.toString()
    }

    override fun getItemCount(): Int {
        return names.size
    }
}