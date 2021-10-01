package com.example.print_sensor

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*

class MainActivity : AppCompatActivity() {
    private var mSensorManager: SensorManager? = null
    private var mHingeAngleSensor: Sensor? = null
    private var mSensorListener: SensorEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList: List<Sensor> = mSensorManager!!.getSensorList(Sensor.TYPE_ALL)
        var num: Int = sensorList.size

        textView.text= "센서의 개수: ${num}개"

       val InfoList=listOf(
                Info(sensorList[0].name,sensorList[0].power,sensorList[0].resolution,
                sensorList[0].maximumRange),

           Info(sensorList[1].name,sensorList[1].power,sensorList[1].resolution,
               sensorList[1].maximumRange),

           Info(sensorList[2].name,sensorList[2].power,sensorList[2].resolution,
               sensorList[2].maximumRange),

           Info(sensorList[3].name,sensorList[3].power,sensorList[3].resolution,
               sensorList[3].maximumRange),

           Info(sensorList[4].name,sensorList[4].power,sensorList[4].resolution,
               sensorList[4].maximumRange),

           Info(sensorList[5].name,sensorList[5].power,sensorList[5].resolution,
               sensorList[5].maximumRange),

           Info(sensorList[6].name,sensorList[6].power,sensorList[6].resolution,
               sensorList[6].maximumRange),

           Info(sensorList[7].name,sensorList[7].power,sensorList[7].resolution,
               sensorList[7].maximumRange),

           Info(sensorList[8].name,sensorList[8].power,sensorList[8].resolution,
               sensorList[8].maximumRange),

           Info(sensorList[9].name,sensorList[9].power,sensorList[9].resolution,
               sensorList[9].maximumRange),

           Info(sensorList[0].name,sensorList[0].power,sensorList[0].resolution,
               sensorList[0].maximumRange),

           Info(sensorList[10].name,sensorList[10].power,sensorList[10].resolution,
               sensorList[10].maximumRange),

           Info(sensorList[11].name,sensorList[11].power,sensorList[11].resolution,
               sensorList[11].maximumRange),

           Info(sensorList[12].name,sensorList[12].power,sensorList[12].resolution,
               sensorList[12].maximumRange),

           Info(sensorList[12].name,sensorList[12].power,sensorList[12].resolution,
               sensorList[0].maximumRange),

           Info(sensorList[12].name,sensorList[0].power,sensorList[0].resolution,
               sensorList[12].maximumRange),

           Info(sensorList[13].name,sensorList[13].power,sensorList[13].resolution,
               sensorList[13].maximumRange),

           Info(sensorList[14].name,sensorList[14].power,sensorList[14].resolution,
               sensorList[14].maximumRange),

           Info(sensorList[15].name,sensorList[15].power,sensorList[15].resolution,
               sensorList[15].maximumRange)
        )

        val infoAdapter = listAdapter(this, InfoList)
        listView.adapter = infoAdapter
    }

}
