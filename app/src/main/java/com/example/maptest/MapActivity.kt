package com.example.maptest;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import org.maplibre.android.MapLibre
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapView

class MapActivity : AppCompatActivity() {

    // Declare a variable for MapView
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Init MapLibre
        MapLibre.getInstance(this)

        // Init layout view
        val inflater = LayoutInflater.from(this)
        val rootView = inflater.inflate(R.layout.activity_map, null, false)  // Attach to root as false
        setContentView(rootView)

        // Init the MapView
        mapView = rootView.findViewById(R.id.mapView)
        mapView.getMapAsync { map ->
            map.setStyle("https://demotiles.maplibre.org/style.json")
            map.cameraPosition = CameraPosition.Builder().target(LatLng(32.0,35.0)).zoom(5.0).build()
        }
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}
