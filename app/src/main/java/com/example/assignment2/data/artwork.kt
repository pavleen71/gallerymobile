package com.example.assignment2.data

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.assignment2.R


data class artwork(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val artist: Int,
    val year:Int
)
val arts= listOf(
    artwork(R.drawable.las_meninas_1656_diego_velazquez,R.string.las_meninas,R.string.las_meninas_artist,1656),
    artwork(R.drawable.starry_night_1889_by_vincent_van_gogh,R.string.starry_night,R.string.starry_night_artist,1889),
    artwork(R.drawable.girl_with_a_pearl_earring_by_johannes_vermeer,R.string.girl_with_pearl_earring,R.string.girl_with_pearl_earring_artist,1665)
)
