package com.prabha.examplemvvm.ui.launcher.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Keep
class DataResponse () {
    @SerializedName("DataResponse")
    @Expose
    var DataResponse: DataResponseStruct? = null
}


