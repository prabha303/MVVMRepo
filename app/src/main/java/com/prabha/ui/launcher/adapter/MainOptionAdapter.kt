package com.prabha.examplemvvm.ui.launcher.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prabha.smi.R
import com.prabha.examplemvvm.ui.launcher.model.DataList
import kotlinx.android.synthetic.main.main_activity.*


class MainOptionAdapter(var context: Context, var dataList: ArrayList<DataList>): RecyclerView.Adapter<MainOptionAdapter.Companion.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_options_item, parent, false)
        val myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val docItem = dataList.get(holder.adapterPosition)
        holder.mainItem.text = docItem.Category
        holder.totalItems.text = docItem.TotalItems
        holder.itemDesc.text = docItem.ItemDesc
        holder.recyclerView.visibility = View.GONE

        holder.expand_button.setOnClickListener {
          //  (context as IActionInterface).onAction(it.id, docItem)
            holder.recyclerView.visibility = View.VISIBLE
            holder.collapse_button.visibility = View.VISIBLE
            holder.expand_button.visibility = View.GONE
            holder.itemDesc.visibility = View.GONE
            holder.viewCode.visibility = View.VISIBLE
            holder.totalItems.visibility = View.VISIBLE
        }

        holder.collapse_button.setOnClickListener {
            //  (context as IActionInterface).onAction(it.id, docItem)
            holder.recyclerView.visibility = View.GONE
            holder.collapse_button.visibility = View.GONE
            holder.expand_button.visibility = View.VISIBLE
            holder.itemDesc.visibility = View.VISIBLE
            holder.viewCode.visibility = View.GONE
            holder.totalItems.visibility = View.GONE
        }
        val subOptionAdapter = SubOptionAdapter(context,dataList.get(position).SubCategory!!, dataList.get(position).Category!!, dataList.get(position).CategoryId!!)
        holder.recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        holder.recyclerView.setHasFixedSize(true)
        holder.recyclerView.adapter = subOptionAdapter
    }


    companion object {
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var mainItem: TextView
            var totalItems: TextView
            var itemDesc: TextView
            var root_layout : LinearLayout
            var recyclerView : RecyclerView
            var expand_button : ImageView
            var collapse_button : ImageView
            var viewCode : View
            init {
                mainItem = view.findViewById(R.id.mainItem)
                totalItems = view.findViewById(R.id.totalItems)
                itemDesc = view.findViewById(R.id.itemDesc)
                root_layout = view.findViewById(R.id.root_layout)
                recyclerView = view.findViewById(R.id.recyclerView)
                expand_button = view.findViewById(R.id.expand_button)
                collapse_button = view.findViewById(R.id.collapse_button)
                viewCode = view.findViewById(R.id.viewCode)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}