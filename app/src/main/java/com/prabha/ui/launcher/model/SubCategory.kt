package com.prabha.examplemvvm.ui.launcher.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Keep
class SubCategory () : Parcelable {



    @SerializedName("name")
    @Expose
    var Name: String? = ""

    @SerializedName("id")
    @Expose
    var Id: String? = ""

    @SerializedName("price")
    @Expose
    var price: String? = ""

    constructor(parcel: Parcel) : this() {
        Name = parcel.readString()
        Id = parcel.readString()
        price = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeString(Id)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubCategory> {
        override fun createFromParcel(parcel: Parcel): SubCategory {
            return SubCategory(parcel)
        }

        override fun newArray(size: Int): Array<SubCategory?> {
            return arrayOfNulls(size)
        }
    }


}


