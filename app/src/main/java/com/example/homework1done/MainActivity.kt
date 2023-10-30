package com.example.homework1done

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var grid : RecyclerView
    private var orientation : Int = 0
    private var rectangles : MutableList<RectangleInfo> = mutableListOf()
    private var num : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        orientation = Configuration.ORIENTATION_PORTRAIT

        grid = findViewById(R.id.GRID)
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            grid.layoutManager = GridLayoutManager(this, 3) else
            grid.layoutManager = GridLayoutManager(this, 4)
        grid.adapter = CustomAdapter(rectangles)

        val button : Button = findViewById(R.id.BUTTON)
        button.setOnClickListener {
            num += 1
            val rectangle = RectangleInfo(if (num % 2 == 0) R.color.red else R.color.blue, num)
            rectangles.add(rectangle)
            (grid.adapter)?.notifyItemInserted(rectangles.size - 1)
        }
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            grid.layoutManager = GridLayoutManager(this, 3)
            orientation = Configuration.ORIENTATION_PORTRAIT
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            grid.layoutManager = GridLayoutManager(this, 4)
            orientation = Configuration.ORIENTATION_LANDSCAPE
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}