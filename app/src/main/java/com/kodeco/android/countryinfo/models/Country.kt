package com.kodeco.android.countryinfo.models

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Country(

    val name: CountryName,
    val capital: List<String>?,
    val population: Long,
    val area: Float,
    val flags: CountryFlags,
): Parcelable {
    val mainCapital = capital?.firstOrNull() ?: "N/A"
    val commonName = name.common
    val flagUrl = flags.png
}
