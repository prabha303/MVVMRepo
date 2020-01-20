package com.prabha.examplemvvm.ui.launcher.viewmodel

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.prabha.examplemvvm.ui.launcher.model.DataResponse
import com.prabha.examplemvvm.ui.launcher.model.SubCategory

class MainViewModel : ViewModel() {

    private val dataListData = MutableLiveData<DataResponse>()
    private val totalAmount = MutableLiveData<String>()
    private val toast = MutableLiveData<String>()


    fun getInfo(jsonObject: String) {
        val g = Gson()
        val dataRes = g.fromJson(jsonObject, DataResponse::class.java)
        for (item in dataRes.DataResponse!!.DataList!!) {
            val count = ""+item.SubCategory!!.size
            val totalItem  = count  + " items"
            var itemDesc = totalItem
            for (subItems in item.SubCategory!!) {
                if (!TextUtils.isEmpty(itemDesc)) {
                    itemDesc = itemDesc + ", "+ subItems.Name
                }else {
                    itemDesc = subItems.Name!!
                }
            }
            itemDesc = itemDesc + " and more"
            Log.e("itemDesc",""+itemDesc)
            item.TotalItems = totalItem
            item.ItemDesc = itemDesc
        }
        dataListData.postValue(dataRes)
     }


    fun calcTotalValue(action: Boolean, subCategory: SubCategory, category: String,totalPrice: String) {
        var totalAmt = 0.0
        val totInt = totalPrice.toDouble()
        var selectedAmt = 0
        if (!TextUtils.isEmpty(subCategory.price)){
            selectedAmt = subCategory.price!!.toInt()
        }
        if (action) {
            totalAmt =  totInt.plus(selectedAmt)
            toast.postValue("${category} - ${subCategory.Name} added")
        }else {
            totalAmt =  totInt.minus(selectedAmt)
            toast.postValue("${category} - ${subCategory.Name} removed")
        }
        totalAmount.postValue("${totalAmt}")
    }


    fun getDataList() = dataListData
    fun getTotalAmount() = totalAmount
    fun showToast() = toast


}