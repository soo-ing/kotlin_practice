package com.example.calculator3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var num1=0.0
    private var num2=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        val arr =arrayOf(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)

        for(i in 0..arr.size-1) {
            when (i) {
                in 0..9 -> {
                    arr[i].setOnClickListener {
                        if (et01.isFocused) {
                            val num = et01.text.toString()
                            et01.setText(num + i)
                        } else if (et02.isFocused) {
                            val num = et02.text.toString()
                            et02.setText(num + i)

                        }
                    }
                }
            }
        }

        btn_add.setOnClickListener {
            if(et01.text.toString()=="" || et02.text.toString()==""){
                toast("숫자를 입력하세요")
            }else{
                saveData(et01.text.toString().toInt(),
                        et02.text.toString().toInt())
                num1=et01.text.toString().toDouble()
                num2=et02.text.toString().toDouble()
                val result=num1+num2
                resultText.text="계산 결과: $result"
                toast("$result")
            }
        }

        btn_minus.setOnClickListener {
            if(et01.text.toString()=="" || et02.text.toString()==""){
                toast("숫자를 입력하세요")
            }else{
                saveData(et01.text.toString().toInt(),
                        et02.text.toString().toInt())
                num1=et01.text.toString().toDouble()
                num2=et02.text.toString().toDouble()
                val result=num1-num2
                resultText.text="계산 결과: $result"
                toast("$result")
            }
        }

        btn_multi.setOnClickListener {
            if(et01.text.toString()=="" || et02.text.toString()==""){
                toast("숫자를 입력하세요")
            }else{
                saveData(et01.text.toString().toInt(),
                        et02.text.toString().toInt())
                num1=et01.text.toString().toDouble()
                num2=et02.text.toString().toDouble()
                val result=num1*num2
                resultText.text="계산 결과: $result"
                toast("$result")
            }
        }

        btn_div.setOnClickListener {
            if(et01.text.toString()=="" || et02.text.toString()==""){
                toast("숫자를 입력하세요")
            }else if(et01.text.toString()=="0" || et02.text.toString()=="0") {
                toast("0이 아닌 다른 숫자를 입력하세요")
            }else{
                saveData(et01.text.toString().toInt(),
                        et02.text.toString().toInt())
                num1=et01.text.toString().toDouble()
                num2=et02.text.toString().toDouble()
                val result=num1/num2
                resultText.text="계산 결과: $result"
                toast("$result")
            }
        }

        btn_del1.setOnClickListener {
            et01.text=null

        }

        btn_del2.setOnClickListener {
            et02.text = null
        }

        btn_all.setOnClickListener {
            et01.text=null
            et02.text=null
            resultText.text="계산 결과: "
        }

    }
    private fun saveData(num1: Int, num2: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", num1)
                .putInt("KEY_WEIGHT", num2)
                .apply()
    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val num1 = pref.getInt("KEY_HEIGHT", 0)
        val num2 = pref.getInt("KEY_WEIGHT", 0)

        if (num1 != 0 && num2!= 0) {
            et01.setText(num1.toString())
            et02.setText(num2.toString())
        }
    }
}