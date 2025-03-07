package com.example.myshoppinglistapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.android.gms.maps.model.CameraPosition

@Composable
fun LocationSelectionScreren(
    location: LocationData,
    onLocationSelected: (LocationData) -> Unit){

    val userLocation = remember{
        mutableStateOf(LatLng(location.latitude, location.longitude))
    }

    var cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(userLocation.value, zoom=10f)
    }
}

