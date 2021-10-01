package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time=0
    private var timerTask: Timer?=null
    private var isRunning=false
    private var lap=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play.setOnClickListener {
            isRunning=!isRunning

            if(isRunning){
                start()
            }else
                pause()
        }

        lapButton.setOnClickListener {
            recordLapTime()
        }
        reset.setOnClickListener {
            reset()
        }
    }

    private fun start(){
        play.setImageResource(R.drawable.pause)

        timerTask=timer(period=10){
            time++

            val sec=time/100
            val milli =time%100

            runOnUiThread{
                textView01.text="$sec"
                textView02.text="$milli"
            }
        }
    }

    private fun pause(){
        play.setImageResource(R.drawable.play)

        timerTask?.cancel()
    }

    private fun recordLapTime(){
        val lapTime=this.time
        val textView= TextView(this)
        textView.text="$lap LAB : ${lapTime/100}.${lapTime%100}"

        lapLayout.addView(textView,0)
        lap++
    }
    private fun reset(){
        timerTask?.cancel()

        time=0
        isRunning=false
        play.setImageResource(R.drawable.play)
        textView01.text="0"
        textView02.text="00"

        lapLayout.removeAllViews()
        lap=1
    }
}
