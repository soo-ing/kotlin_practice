package com.example.todolist2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import java.util.*

class EditActivity : AppCompatActivity() {

    var realm = Realm.getDefaultInstance()
    val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val id = intent.getLongExtra("id",-1L)//1:Int, 1L:Long, 1.0:Double, 1.0f:Float
        if (id == -1L) {
            insertMode()
        } else {
            updateMode(id)
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
    private fun insertTodo(){
        realm.beginTransaction()
        val todo=realm.createObject<Todo2>(nextId())
        todo.title=todoEditText1.text.toString()
        todo.num = todoEditText2.text.toString()
        todo.address = todoEditText3.text.toString()
        todo.date=calendar.timeInMillis
        realm.commitTransaction()

        alert("내용이 추가되었습니다."){
            yesButton{
                finish()
            }
        }.show()

    }
    private fun nextId(): Int {
        val maxId = realm.where<Todo2>().max("id")
        if (maxId != null) {
            return maxId.toInt() + 1
        }
        return 0
    }
    private fun updateTodo(id: Long) {
        realm.beginTransaction()
        val todo = realm.where<Todo2>().equalTo("id", id).findFirst()!!//!!:todo는 이후부터 null이 아님
        todo.title = todoEditText1.text.toString()
        todo.num = todoEditText2.text.toString()
        todo.address = todoEditText3.text.toString()
        todo.date = calendar.timeInMillis
        realm.commitTransaction()
        alert("내용이 변경되었습니다.") {
            yesButton { finish() }
        }.show()
    }
    private fun deleteTodo(id: Long) {
        realm.beginTransaction()
        val todo = realm.where<Todo2>().equalTo("id", id).findFirst()!!
        todo.deleteFromRealm()
        realm.commitTransaction()
        alert("내용이 삭제되었습니다.") {
            yesButton { finish() }
        }.show()
    }

    private fun insertMode() {
        deleteFab.visibility = View.GONE
        doneFab.setOnClickListener {
            insertTodo()
        }
    }

    private fun updateMode(id: Long) {
        val todo = realm.where<Todo2>().equalTo("id", id).findFirst()!!
        todoEditText1.setText(todo.title)
        todoEditText2.setText(todo.num)
        todoEditText3.setText(todo.address)
        calendarView.date = todo.date
        doneFab.setOnClickListener {
            updateTodo(id)
        }
        deleteFab.setOnClickListener {
            deleteTodo(id)
        }
    }

}
