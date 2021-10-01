package com.example.todolist2

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Todo2(
    @PrimaryKey var id : Long =0,
    var title : String = "",
    var num:String="",
    var address:String="",
    var date:Long=0

) : RealmObject()