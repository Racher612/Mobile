package com.example.homework1done

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

data class RectangleInfo(
    val color: Int,
    var number: Int
)

class CustomAdapter(private val rectangles: MutableList<RectangleInfo>) : RecyclerView.Adapter<Rectangle>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rectangle {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rectangle, parent, false)
        return Rectangle(itemView)
    }

    override fun onBindViewHolder(holder: Rectangle, position: Int) {

        holder.rectangle.setBackgroundResource(rectangles[position].color)
        holder.rectangle.text = rectangles[position].number.toString()
    }

    override fun getItemCount(): Int {
        return rectangles.size
    }
}