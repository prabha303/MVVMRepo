package com.prabha.examplemvvm.ui.launcher.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Keep
class DataList () {

    @SerializedName("CategoryId")
    @Expose
    var CategoryId: String? = ""

    @SerializedName("Category")
    @Expose
    var Category: String? = ""


    @SerializedName("total_items")
    @Expose
    var TotalItems: String? = ""

    @SerializedName("tem_idesc")
    @Expose
    var ItemDesc: String? = ""



    @SerializedName("subCategory")
    @Expose
    var SubCategory: ArrayList<SubCategory>? = null



}


