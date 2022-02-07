package com.example.lesson4hw

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator


class MemberParcelable : Parcelable {
    var name: String? = null
    var age = 0

    constructor(`in`: Parcel) {
        name = `in`.readString()
        age = `in`.readInt()
    }

    constructor() {}

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }


    companion object CREATOR : Creator<MemberParcelable> {
        override fun createFromParcel(parcel: Parcel): MemberParcelable {
            return MemberParcelable(parcel)
        }

        override fun newArray(size: Int): Array<MemberParcelable?> {
            return arrayOfNulls(size)
        }
    }
}
