package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import java.lang.Math.pow
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        /*resultButton.setOnClickListener {
            val intent= Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }*/

        resultButton.setOnClickListener {
            saveData(editText1.text.toString().toInt(),
                editText2.text.toString().toInt())
            startActivity<ResultActivity>(
                "height" to editText1.text.toString(),
                "weight" to editText2.text.toString()
            )
        }


    }
    private fun saveData(height: Int, weight: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT", 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if(height != 0 && weight != 0) {
            editText1.setText(height.toString())
            editText2.setText(weight.toString())
        }
    }

}
