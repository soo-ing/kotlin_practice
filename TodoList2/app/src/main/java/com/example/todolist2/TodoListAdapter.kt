package com.example.todolist2

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter


class TodoListAdapter(realmResult: OrderedRealmCollection<Todo2>) :
    RealmBaseAdapter<Todo2>(realmResult) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vh: ViewHolder
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_todo, parent, false)
            vh = ViewHolder(view)
            view.tag = vh

        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        if (adapterData != null) {
            val item = adapterData!![position]
            vh.textTextView1.text ="장비명: "+item.title
            vh.textTextView2.text = "개수: "+item.num
            vh.textTextView3.text = "배송지: "+item.address
            vh.dateTextView.text = "날짜: "+DateFormat.format("MM/dd", item.date)
        }

        return view
    }
    override fun getItemId(position: Int): Long {
        if (adapterData != null) {
            return adapterData!![position].id
        }
        return super.getItemId(position)
    }
}
class ViewHolder(view: View) {
    val dateTextView: TextView = view.findViewById(R.id.text1)
    val textTextView1: TextView = view.findViewById(R.id.text2)
    val textTextView2: TextView = view.findViewById(R.id.text3)
    val textTextView3: TextView = view.findViewById(R.id.text4)
}