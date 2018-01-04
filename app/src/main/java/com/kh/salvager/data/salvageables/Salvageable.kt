package com.kh.salvager.data.salvageables

import android.os.Parcel
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng

class Salvageable(var id: Int, var name: String, var description: String, var picturesUris: MutableList <String>, var position: LatLng) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readParcelable(LatLng::class.java.classLoader))

    init {
        if (name.length > NAME_LENGTH_MAX)
            name = name.substring(0, NAME_LENGTH_MAX)
        if (description.length > DESCRIPTION_LENGTH_MAX)
            description = description.substring(0, DESCRIPTION_LENGTH_MAX)
        if (picturesUris.size > PICTURES_LENGTH_MAX)
            picturesUris = picturesUris.subList(0, PICTURES_LENGTH_MAX)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeStringList(picturesUris)
        parcel.writeParcelable(position, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Salvageable> {

        val NAME_LENGTH_MAX = 128
        val DESCRIPTION_LENGTH_MAX = 2048
        val PICTURES_LENGTH_MAX = 5

        override fun createFromParcel(parcel: Parcel): Salvageable {
            return Salvageable(parcel)
        }

        override fun newArray(size: Int): Array<Salvageable?> {
            return arrayOfNulls(size)
        }
    }

}