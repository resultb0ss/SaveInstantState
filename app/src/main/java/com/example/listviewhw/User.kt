package com.example.listviewhw

import android.os.Parcel
import android.os.Parcelable

class User(private val name: String?, private val lastName: String?,private val adress: String?,
           private val phone: Int?): Parcelable {

               constructor(parcel: Parcel) : this (
                   parcel.readString(),
                   parcel.readString(),
                   parcel.readString(),
                   parcel.readInt(),
               ){}

    fun getName(): String? {
        return name
    }

    fun getLastName(): String? {
        return lastName
    }

    fun getPhone(): Int? {
        return phone
    }

    fun getAdress(): String? {
        return adress
    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(name)
        p0.writeString(lastName)
        p0.writeString(adress)
        p0.writeString(phone.toString())
    }



    override fun toString(): String {

        return "Имя: $name Фамилия: $lastName"
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}