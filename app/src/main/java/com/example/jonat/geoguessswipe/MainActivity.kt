package com.example.jonat.geoguessswipe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.ImageView
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var mImageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mImageView = findViewById(R.id.geoImageView)

        val mGeoRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val mGeoObjects = ArrayList<GeoObject>()
        val mAdapter = GeoObjectAdapter(this, mGeoObjects)

        for (i in GeoObject.GEO_OBJECT_NAMES.indices) {
            mGeoObjects.add(GeoObject(GeoObject.GEO_OBJECT_NAMES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]))

            val mLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
            mGeoRecyclerView.layoutManager = mLayoutManager
            mGeoRecyclerView.adapter = mAdapter

        }
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            //Called when a user swipes left or right on a ViewHolder
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {

                //Get the index corresponding to the selected position
                val position = viewHolder.adapterPosition
                if (mGeoObjects[position].getmGeoName()?.contains("yes_")!! &&  swipeDir == 1 shl 2 || mGeoObjects[position].getmGeoName()?.contains("no_")!! &&  swipeDir == 1 shl 3) {
                            Toast.makeText(baseContext, "Correct", Toast.LENGTH_SHORT).show()
                        } else {
                    Toast.makeText(baseContext, "Wrong", Toast.LENGTH_SHORT).show()
                }
                mGeoObjects.removeAt(position)
                mAdapter.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView)

    }
}
