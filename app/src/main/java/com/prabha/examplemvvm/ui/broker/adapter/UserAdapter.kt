package com.prabha.examplemvvm.ui.broker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lynkdriver.lynk.ui.abort.model.MessageStruct
import com.match.matchmakers.R
import java.util.ArrayList

class UserAdapter(private val context: Context, private val messageStructList: ArrayList<MessageStruct>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var  mContext: Context
    val mMessageStructList: ArrayList<MessageStruct>
    init {
        this.mContext = context
        this.mMessageStructList = messageStructList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user_info, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title!!.text = messageStructList[position].tilte
        holder.name!!.text = messageStructList[position].name
        holder.message!!.text = messageStructList[position].message
        holder.mobileNumber!!.text = messageStructList[position].mobile_number
        holder.religion!!.text = messageStructList[position].religion
    }
    override fun getItemCount(): Int {
        return messageStructList.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var title: TextView? = null
        var message: TextView? = null
        var religion: TextView? = null
        var mobileNumber: TextView? = null
        init {
            name = itemView.findViewById<View>(R.id.name) as TextView
            title = itemView.findViewById<View>(R.id.title) as TextView
            message = itemView.findViewById<View>(R.id.message) as TextView
            religion = itemView.findViewById<View>(R.id.religion) as TextView
            mobileNumber = itemView.findViewById<View>(R.id.mobileNumber) as TextView
        }
    }


}
