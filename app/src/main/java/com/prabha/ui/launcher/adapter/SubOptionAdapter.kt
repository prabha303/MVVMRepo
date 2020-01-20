package com.prabha.examplemvvm.ui.launcher.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lynk.cardlibrary.actioninterface.IActionInterface
import com.prabha.smi.R
import com.prabha.examplemvvm.ui.launcher.model.DataList
import com.prabha.examplemvvm.ui.launcher.model.SubCategory
import kotlinx.android.synthetic.main.main_activity.*


class SubOptionAdapter(var context: Context, var dataList: ArrayList<SubCategory>, var category : String, var categoryId: String): RecyclerView.Adapter<SubOptionAdapter.Companion.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_options_item, parent, false)
        val myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val docItem = dataList.get(holder.adapterPosition)
        holder.itemDesc.text = docItem.Name
        val price = "$" + docItem.price
        holder.price.text =price

        holder.add.setOnClickListener {
            holder.add.visibility = View.GONE
            holder.add_remove_layout.visibility = View.VISIBLE
            val quantity = holder.quantity.text as String
            if (!TextUtils.isEmpty(quantity)) {
                val new_q = quantity.toInt() + 1
                holder.quantity.text = ""+new_q
            }
            (context as IActionInterface).onAction(true, docItem, category)
        }
        holder.minus_quantity.setOnClickListener {
            val quantity = holder.quantity.text as String
            if (!TextUtils.isEmpty(quantity)) {

                val new_q = quantity.toInt() - 1
                if (new_q <= 0) {
                    holder.add.visibility = View.VISIBLE
                    holder.add_remove_layout.visibility = View.GONE
                }
                holder.quantity.text = ""+new_q
            }
            (context as IActionInterface).onAction(false, docItem, category)
        }
        holder.add_quantity.setOnClickListener {
            val quantity = holder.quantity.text as String
            if (!TextUtils.isEmpty(quantity)) {
                val new_q = quantity.toInt() + 1
                holder.quantity.text = ""+new_q
            }
            (context as IActionInterface).onAction(true, docItem, category)
        }
    }
    companion object {
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var itemDesc: TextView
            var price : TextView
            var add : TextView
            var minus_quantity : TextView
            var quantity : TextView
            var add_quantity : TextView
            var add_remove_layout : LinearLayout
            init {
                itemDesc = view.findViewById(R.id.itemDesc)
                price = view.findViewById(R.id.price)
                add = view.findViewById(R.id.add)
                minus_quantity = view.findViewById(R.id.minus_quantity)
                quantity = view.findViewById(R.id.quantity)
                add_quantity = view.findViewById(R.id.add_quantity)
                add_remove_layout = view.findViewById(R.id.add_remove_layout)
            }
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}