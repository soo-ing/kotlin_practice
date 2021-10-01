package com.example.drawing_board

import android.R.color
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable.LINE
import android.icu.lang.UCharacter.DecompositionType.CIRCLE
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val paint = Paint()


    init {
        paint.color = Color.GREEN
        paint.style = Paint.Style.STROKE
    }
    private lateinit var myShape: MyShape

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myShape= MyShape(this)
        setContentView(myShape)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.menu1 -> {
                myShape.shape=1
            }
            R.id.menu2 -> {
                myShape.shape=2
            }
            R.id.menu3 -> {
                myShape.shape=3
            }
            R.id.menu_red -> {
                myShape.shape=4
            }
            R.id.menu_green -> {
                myShape.shape=5
            }
            R.id.menu_blue -> {
                myShape.shape=6
            }

        }
        return super.onOptionsItemSelected(item)
    }

}



