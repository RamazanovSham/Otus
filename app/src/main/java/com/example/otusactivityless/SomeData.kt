package com.example.otusactivityless

import android.graphics.drawable.BitmapDrawable
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class FilmData (val name:String, val description: String, val Image: Int  ) :  Parcelable

@Parcelize
class ReturnValue (val comment: String, val Is_liked:Boolean ) :  Parcelable


