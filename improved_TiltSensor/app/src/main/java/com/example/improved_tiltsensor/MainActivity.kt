package com.example.improved_tiltsensor

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), SensorEventListener {

    private val sensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    private lateinit var tiltView : TiltView

    private val vibrator by lazy {
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE


        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        tiltView=TiltView(this)
        setContentView(tiltView)



    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(
                this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            tiltView.onSensorEvent(event)
            var xCoord=tiltView.getXCoord()
            var yCoord=tiltView.getYCoord()

            if((xCoord>200||xCoord<-200)||(yCoord>200||yCoord<-200)){
                vibrator.vibrate(VibrationEffect.createOneShot(3000, VibrationEffect.DEFAULT_AMPLITUDE))
                Log.d("MainActivity","out")
            }else{
                Log.d("MainActivity","in")
            }

        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }




}
