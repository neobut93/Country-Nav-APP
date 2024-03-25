package com.kodeco.android.countryinfo.models

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class CountryFlags(val png: String, val svg: String): Parcelable