package com.example.homework1done

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Rectangle(itemView : View) : RecyclerView.ViewHolder(itemView){
    var rectangle = itemView.findViewById<TextView>(R.id.RECTANGLE)!!
}