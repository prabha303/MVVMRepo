package com.match.matchmakers.ui.launcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lynkdriver.lynk.ui.abort.model.MessageStruct
import com.match.matchmakers.R
import com.match.matchmakers.base.view.BaseActivity
import com.match.matchmakers.ui.launcher.main.LauncherFragment
import com.match.matchmakers.ui.launcher.main.MainFragment
import com.match.matchmakers.ui.launcher.main.SplashFragment
import com.prabha.examplemvvm.ui.broker.adapter.UserAdapter
import kotlinx.android.synthetic.main.broker_list_activity.*

class BrokerListActivty :AppCompatActivity()  /*BaseActivity()*/ {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.broker_list_activity)

        val list = ArrayList<MessageStruct>()

        val struct = MessageStruct()
        struct.message = "New Joiny"
        struct.mobile_number = "7829332005"
        struct.tilte = "Actively looking for match"
        struct.name = "Nithin MK DS"
        struct.religion = "Hindu"
        list.add(struct)

        val struct1 = MessageStruct()
        struct1.message = "New Joiny"
        struct1.mobile_number = "7829332005"
        struct1.tilte = "match found"
        struct1.name = "Nithin NEW DS MS"
        struct1.religion = "Hindu"
        list.add(struct1)

        val struct2 = MessageStruct()
        struct2.message = "New Joiny"
        struct2.mobile_number = "7829332005"
        struct2.tilte = "Actively looking for match"
        struct2.name = "John Bright AD"
        struct2.religion = "Hindu"
        list.add(struct2)

        val struct3 = MessageStruct()
        struct3.message = "Rishap Pant Delhi"
        struct3.mobile_number = "7829332005"
        struct3.tilte = "Actively looking for match"
        struct3.name = "John Bright AD"
        struct3.religion = "Hindu"
        list.add(struct3)

        val struct4 = MessageStruct()
        struct4.message = "New Joiny Tomas"
        struct4.mobile_number = "7829332005"
        struct4.tilte = "Looking only match found"
        struct4.name = "Nithin NEW DS MS"
        struct4.religion = "Hindu"
        list.add(struct4)

        val manager = LinearLayoutManager(this@BrokerListActivty)
        recyclerView.setLayoutManager(manager)
        val newAdapter = UserAdapter(this,list)
        recyclerView.adapter = newAdapter
    }






}
