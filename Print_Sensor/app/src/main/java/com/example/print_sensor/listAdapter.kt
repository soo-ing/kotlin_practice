package com.example.print_sensor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class listAdapter (val context : Context, val list : List<Info>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val holder : viewHolder

        // convertView가 최초로 생성
        if (convertView == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.item, null)
            holder = viewHolder()
            holder.name = view.findViewById(R.id.text1)
            holder.power = view.findViewById(R.id.text2)
            holder.res = view.findViewById(R.id.text3)
            holder.range = view.findViewById(R.id.text4)
            view.tag = holder
        }
        // 보이지 않던 View가 다시 보여짐
        else
        {
            view = convertView
            holder = view.tag as viewHolder
        }

        val info = list[position]
        holder.name?.text = info.name
        holder.power?.text = info.power.toString()
        holder.res?.text = info.res.toString()
        holder.range?.text = info.range.toString()

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.count()
    }
}
private class viewHolder (var name : TextView? = null, var power : TextView? = null
                          , var res : TextView? = null, var range : TextView? = null)