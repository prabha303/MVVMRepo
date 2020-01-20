package com.prabha.smi.ui.launcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabha.smi.R
import kotlinx.android.synthetic.main.main_activity.*
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.lynk.cardlibrary.actioninterface.IActionInterface
import com.prabha.examplemvvm.ui.launcher.Util
import com.prabha.examplemvvm.ui.launcher.adapter.MainOptionAdapter
import com.prabha.examplemvvm.ui.launcher.model.DataResponse
import com.prabha.examplemvvm.ui.launcher.model.SubCategory
import com.prabha.examplemvvm.ui.launcher.viewmodel.MainViewModel


class MainActivity : AppCompatActivity(), IActionInterface {

    private var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        mainViewModel!!.getInfo(Util.readJSONFromAsset(this@MainActivity)!!)
        observeViewModel()

    }

    fun observeViewModel() {
        mainViewModel!!.getDataList().observe(this, object : androidx.lifecycle.Observer<DataResponse> {
            override fun onChanged(dataList: DataResponse?) {

                restaurant_name.text = dataList!!.DataResponse!!.RestaurantName
                cuisine.text = dataList.DataResponse!!.Cuisine
                delivery_time.text = dataList.DataResponse!!.DeliveryTime

                val mainOptionAdapter = MainOptionAdapter(this@MainActivity,dataList.DataResponse!!.DataList!!)
                recyclerView.adapter = mainOptionAdapter
            }
        })
        mainViewModel!!.getTotalAmount().observe(this, object : androidx.lifecycle.Observer<String> {
            override fun onChanged(totalAmount: String?) {
                totalPrice.text = "$totalAmount"
            }
        })
        mainViewModel!!.showToast().observe(this, object : androidx.lifecycle.Observer<String> {
            override fun onChanged(message : String) {

                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onAction(action: Boolean, model: SubCategory, category: String) {
        mainViewModel!!.calcTotalValue(action,model,category, totalPrice.text as String)
    }
}
