package com.tarantulahawk.dsrpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = map as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap?) {

        val regions = listOf(
            LatLng(59.327069, 18.103741), //Museu ao ar livre Skanse
            LatLng(55.686200, 12.576480), //Castelo Rosenborg
            LatLng(55.681377, 12.575730), //Torre redonda de Rundetarn
            LatLng(64.070423, -16.975519), //Parque Nacional Skaftafell
            LatLng(62.107793, -7.597646), //Mykines
            LatLng(62.107717, -7.435389), //Cachoeira Mulafossur
            LatLng(55.366584, 10.385367), //The Funen Village
            LatLng(64.256022, -21.129625), //Parque Nacional de Thingvellir
            LatLng(59.321693, 17.886857), //Palácio de Drottningholm
            LatLng(64.142032, -21.926528), //Igreja Hallgrimskirkja
            LatLng(56.039008, 12.621166) //Castelo de Kronborg
        )
        //Eu sei que seria melhor eu fazer uma lista de strings em strings e pegar por lá para tradução mais facil, mas eu só não to com vontade mesmo
        val regionsNames = listOf(
            "Museu ao ar livre Skanse",
            "Castelo Rosenborg",
            "Torre redonda de Rundetarn",
            "Parque Nacional Skaftafell",
            "Mykines",
            "Cachoeira Mulafossur",
            "The Funen Village",
            "Parque Nacional de Thingvellir",
            "Palácio de Drottningholm",
            "Igreja Hallgrimskirkja",
            "Castelo de Kronborg"
        )

        var lat = 0.0
        var long = 0.0

        regions.forEachIndexed() { index, it ->
            addMarker(googleMap, it, regionsNames[index])
            lat+=it.latitude
            long+=it.longitude
        }

        lat/=regions.size
        long/=regions.size

        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(LatLng(lat,long)))

        googleMap?.animateCamera(CameraUpdateFactory.zoomTo(3f))

        googleMap?.isIndoorEnabled = true
    }

    private fun addMarker(map:GoogleMap?, position:LatLng, name:String){
        val markerOptions = MarkerOptions()
            .position(position)
            .title(name)
        map?.addMarker(markerOptions)
    }
}