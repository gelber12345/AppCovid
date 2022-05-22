package com.example.appcovid.Screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.appcovid.Navigation.AppScreens
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.example.appcovid.R
import com.example.appcovid.model.MarkerMap


@Composable
fun FirstScreen(navController: NavController) {
    // Ubicación por defecto: Hospital Honorio Delgado Espinoza
    val posicionInicial = LatLng(-16.415428615723567, -71.53298460179624)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(posicionInicial, 15f)
    }

    val context = LocalContext.current
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(
            mapStyleOptions = MapStyleOptions.loadRawResourceStyle(
                context, R.raw.style_json
            )
        )
    ) {
        MarkerMap.getListIterator().forEach {
            MapMarker(it, navController)
        }
    }

}

@Composable
fun MapMarker(mark: MarkerMap.Mark, navController: NavController) {
    val aux by remember { mutableStateOf(LatLng(mark.latitud, mark.longitud)) }
    Log.d("MY MARKET", "ENTRE $aux")

    Marker(
        position = aux,
        title = mark.nombre,
        onInfoWindowClick = {
            try {
                GlobalScope.launch(Dispatchers.Main) {
                    navController.navigate(AppScreens.DetalleScreen.route + "/${mark.nombre}")
                }
            } catch (ex: Exception) {
                Log.d("ONCLICK", "" + ex)
            }

        }
    )
}