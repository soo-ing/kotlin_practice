package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var num1=0.0
    private var num2=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        bt01.setOnClickListener {
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

        bt02.setOnClickListener {
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

        bt03.setOnClickListener {
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

        bt04.setOnClickListener {
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

        del01.setOnClickListener {
            et01.text=null
        }

        del02.setOnClickListener {
            et02.text = null
        }

        del03.setOnClickListener {
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
