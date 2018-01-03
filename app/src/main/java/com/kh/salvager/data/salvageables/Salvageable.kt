package com.kh.salvager.data.salvageables

import android.os.Parcel
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import java.io.Serializable

class Salvageable(var id: Int, var name: String, var description: String, var pictureUri: String, var position: LatLng) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(LatLng::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(pictureUri)
        parcel.writeParcelable(position, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Salvageable> {
        override fun createFromParcel(parcel: Parcel): Salvageable {
            return Salvageable(parcel)
        }

        override fun newArray(size: Int): Array<Salvageable?> {
            return arrayOfNulls(size)
        }
    }


}