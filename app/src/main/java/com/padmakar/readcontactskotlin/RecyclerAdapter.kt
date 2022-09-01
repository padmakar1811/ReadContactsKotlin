package com.padmakar.readcontactskotlin

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.padmakar.readcontactskotlin.R
import android.widget.TextView
import android.widget.LinearLayout
import java.util.ArrayList

class RecyclerAdapter(private var context: Context, var cont: List<Contacts>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var list: Contacts? = null
    private val arraylist: ArrayList<Contacts>
    var checked = false
    var vv: View? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v =
            layoutInflater.inflate(R.layout.contactlist_row, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list = cont[position]
        val name = list!!.name
        holder.title.text = name
        holder.phone.text = list!!.phone
    }

    override fun getItemCount(): Int {
        return cont.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var phone: TextView
        var contact_select_layout: LinearLayout

        init {
            setIsRecyclable(false)
            title = itemView.findViewById<View>(R.id.name) as TextView
            phone = itemView.findViewById<View>(R.id.no) as TextView
            contact_select_layout =
                itemView.findViewById<View>(R.id.contact_select_layout) as LinearLayout
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    init {
        arraylist = ArrayList()
        arraylist.addAll(cont)
    }
}