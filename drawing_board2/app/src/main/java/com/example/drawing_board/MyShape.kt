package com.example.drawing_board

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyShape(context: Context?) : View(context) {
        private var cX:Float=0f
        private var cY:Float=0f
        private val paint: Paint = Paint()
        public var shape:Int=0

        init {
                paint.color= Color.RED
                paint.style= Paint.Style.STROKE
                paint.strokeWidth=10.0f
        }
        override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
                cX=w/2f
                cY=h/2f
        }

        override fun onDraw(canvas: Canvas?) {
                when(shape) {
                        1 -> {
                                canvas?.drawLine(cX - 200, cY, cX + 200, cY, paint)
                        }
                        2 -> {
                                canvas?.drawCircle(cX, cY, 200f, paint)
                        }
                        3 -> {
                                canvas?.drawRect(cX - 200, cY - 200, cX + 200, cY + 200, paint)
                        }
                        4 -> {
                                paint.color = Color.RED
                        }
                        5 -> {
                                paint.color = Color.GREEN
                        }
                        6 -> {
                                paint.color = Color.BLUE
                        }
                }
                invalidate()
        }
}
