package com.example.jonat.geoguessswipe

class GeoObject(private var mGeoName: String?, private var mGeoImageName: Int) {

    fun getmGeoName(): String? {
        return mGeoName
    }

    fun setmGeoName(mGeoName: String) {
        this.mGeoName = mGeoName
    }

    fun getmGeoImageName(): Int {
        return mGeoImageName
    }

    fun setmGeoImageName(mGeoImageName: Int) {
        this.mGeoImageName = mGeoImageName
    }

    companion object {

        val GEO_OBJECT_NAMES = arrayOf("yes_Denemarken", "no_Canada", "no_Bangladesh", "yes_Kazachstan", "no_Colombia", "yes_Poland", "yes_Malta", "no_Thailand")
        val PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = intArrayOf(R.drawable.img1_yes_denmark, R.drawable.img2_no_canada, R.drawable.img3_no_bangladesh, R.drawable.img4_yes_kazachstan, R.drawable.img5_no_colombia, R.drawable.img6_yes_poland, R.drawable.img7_yes_malta, R.drawable.img8_no_thailand)
    }
}
