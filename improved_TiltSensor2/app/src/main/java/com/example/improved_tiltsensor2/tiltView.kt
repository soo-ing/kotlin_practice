package com.example.improved_tiltsensor2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.SensorEvent
import android.view.View

class TiltView(context: Context?) : View(context) {
    private var cX:Float=0f
    private var cY:Float=0f
    private val greenPaint: Paint = Paint()
    private val blackPaint: Paint = Paint()
    private var yCoord:Float=0f
    private var xCoord:Float=0f

    init {
        greenPaint.color= Color.GREEN
        blackPaint.style= Paint.Style.STROKE
    }
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

        cX=w/2f
        cY=h/2f
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(cX,cY,100f,blackPaint)
        canvas?.drawCircle(cX+xCoord,cY+yCoord,100f,greenPaint)

        canvas?.drawLine(cX-20,cY,cX+20,cY,blackPaint)
        canvas?.drawLine(cX,cY-20,cX,cY+20,blackPaint)

    }


    fun onSensorEvent(event: SensorEvent){
        yCoord=event.values[0]*30
        xCoord=event.values[1]*30

        invalidate()
    }
    fun getXCoord():Float{
        return this.xCoord
    }
    fun getYCoord():Float{
        return this.yCoord
    }

}