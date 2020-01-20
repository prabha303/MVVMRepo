package com.prabha.ui.launcher.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Keep
class DataResponseStruct () /*: Parcelable */{

    @SerializedName("Status")
    @Expose
    var Status: String? = ""

    @SerializedName("restaurant_name")
    @Expose
    var RestaurantName: String? = ""


    @SerializedName("address_block_name")
    @Expose
    var AddressBlockName: String? = ""


    @SerializedName("address_city")
    @Expose
    var AddressCity: String? = ""


    @SerializedName("address_state")
    @Expose
    var AddressState: String? = ""

    @SerializedName("cuisine")
    @Expose
    var Cuisine: String? = ""


    @SerializedName("Ratings")
    @Expose
    var Ratings: String? = ""


    @SerializedName("delivery_time")
    @Expose
    var DeliveryTime: String? = ""


    @SerializedName("dataList")
    @Expose
    var DataList: ArrayList<DataList>? = null
}


