package co.devpartners.devhub.api.events

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.devpartners.devhub.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val DevPartners = LatLng(-122.0840, 37.4220)
        mMap.addMarker(MarkerOptions().position(DevPartners).title("Dev Partners"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DevPartners))
    }
}
