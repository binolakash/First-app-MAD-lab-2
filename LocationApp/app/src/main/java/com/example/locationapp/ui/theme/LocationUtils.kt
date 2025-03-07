package com.example.locationapp.ui.theme

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import android.Manifest
import android.annotation.SuppressLint
import android.location.Geocoder
import android.os.Looper
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import java.util.Locale

class LocationUtils(var context:Context) {

    private val _fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun requestLocationUpdates(viewModel: LocationViewModel) {
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                locationResult.lastLocation?.let {
                    val location = LocationData(latitude = it.latitude, longitude = it.longitude)
                    viewModel.updateLocation(location)
                }
            }
        }

        val locationRequest: LocationRequest.Builder(
        Priority.PRIORITY_HIGH_ACCURACY, intervalMillis = 1000).build()

        _fusedLocationClient.removeLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    fun hasLocationPermission(contex: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED

    }

    fun reversrGeocodeLocation(location: LocationData): String {
        val goecoder = Geocoder(context, Locale.getDefault())
        val coordinate = Latlng(location.latitude,location.longitude)
        val addresses.MutableList<Address>?=
               geocoder.getFromLocation(coordinate.latitude,coordinate.longitude,maxResults=1)
        return if(addresses?isNotEmpty()==true){
            addresses[0].getAddressLine(index=0)
        }else{
            "Address not found"
        }
    }

}