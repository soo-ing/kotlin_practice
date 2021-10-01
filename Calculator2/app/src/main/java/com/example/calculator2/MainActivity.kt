package com.example.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    private var num1=0.0
    private var num2=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(resultText)

        loadData()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.menu_add->{
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
                return true
            }

            R.id.menu_minus ->{
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
                return true
            }

            R.id.menu_multi->{
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
                return true
            }

            R.id.menu_div ->{
                if(et01.text.toString()=="" || et02.text.toString()==""){
                    toast("숫자를 입력하세요")
                }else{
                    saveData(et01.text.toString().toInt(),
                            et02.text.toString().toInt())
                    num1=et01.text.toString().toDouble()
                    num2=et02.text.toString().toDouble()
                    val result=num1/num2
                    resultText.text="계산 결과: $result"
                    toast("$result")
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.context_del1->{
                et01.text=null
            }

            R.id.context_del2->{
                et02.text=null
            }

            R.id.context_all->{
                et01.text=null
                et02.text=null
                resultText.text="계산 결과: "
            }
        }
        return super.onContextItemSelected(item)
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