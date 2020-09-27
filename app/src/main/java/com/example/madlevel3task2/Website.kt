package com.example.madlevel3task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Website(var websiteTitleText: String,var websiteURLText: String): Parcelable

