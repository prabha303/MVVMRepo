package com.lynkdriver.lynk.ui.abort.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Keep
class MessageStruct (): Parcelable {

    @SerializedName("tilte")
    @Expose
    var tilte: String? = ""

    @SerializedName("message")
    @Expose
    var message: String? = ""

    @SerializedName("mobile_number")
    @Expose
    var mobile_number: String? = ""

    @SerializedName("name")
    @Expose
    var name: String? = ""

    @SerializedName("religion")
    @Expose
    var religion: String? = ""

    constructor(parcel: Parcel) : this() {
        tilte = parcel.readString()
        message = parcel.readString()
        mobile_number = parcel.readString()
        name = parcel.readString()
        religion = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tilte)
        parcel.writeString(message)
        parcel.writeString(mobile_number)
        parcel.writeString(name)
        parcel.writeString(religion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MessageStruct> {
        override fun createFromParcel(parcel: Parcel): MessageStruct {
            return MessageStruct(parcel)
        }

        override fun newArray(size: Int): Array<MessageStruct?> {
            return arrayOfNulls(size)
        }
    }


}


