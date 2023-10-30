package com.example.homework1done

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var grid : RecyclerView
    private lateinit var elems : MutableList<RectangleInfo>
    private lateinit var button : Button
    private var num : Int = 0
    private var red = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        elems = mutableListOf()

        grid = findViewById(R.id.GRID)
        grid.layoutManager = GridLayoutManager(this, 3)
        grid.adapter = CustomAdapter(elems)

        button = findViewById(R.id.BUTTON)
        button.setOnClickListener {
            num += 1
            elems.add(RectangleInfo(if (red) R.color.red else R.color.blue, num))
            red = !red
            grid.adapter = CustomAdapter(elems)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            grid.layoutManager = GridLayoutManager(this, 3)
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            grid.layoutManager = GridLayoutManager(this, 4)
        }
    }
}