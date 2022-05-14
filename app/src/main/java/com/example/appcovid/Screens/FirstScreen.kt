package com.example.appcovid.Screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun FirstScreen(navController: NavController){
    val HonorioDelgado = LatLng(-16.415428615723567, -71.53298460179624)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(HonorioDelgado, 15f)
    }
    val context = LocalContext.current
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ){
        MapMarker(Mark ("HonorioDelgado",-16.415428615723567,-71.53298460179624), navController)
        /*Marker(
            position = HonorioDelgado,
            title = "HonorioDelgado",
            snippet = "Hospital Honorio Delgado",
            onInfoWindowClick = {
                Toast.makeText(
                    context,
                    "Showing toast....",
                    Toast.LENGTH_LONG
                ).show()
                try {
                    Log.d("PASANDO", "Intentare")
                    GlobalScope.launch(Dispatchers.Main) {
                        navController.navigate(AppScreens.DetalleScreen.route + this.)
                    }

                } catch (ex: Exception) {
                    Log.d("ONCLICK", ""+ ex)
                }

            }
        )*/

    }

}
data class Mark(val name:String , val lat : Double ,val lon: Double)

@Composable
fun MapMarker(mark : Mark,navController: NavController){
    val aux  by remember { mutableStateOf(LatLng(mark.lat, mark.lon)) }
    Log.d("MY MARKET", "ENTRE $aux" )
    Marker(

        position = aux,
        title = mark.name,
        snippet =  mark.name,
        onInfoWindowClick = {
            try {
                GlobalScope.launch(Dispatchers.Main) {
                    navController.navigate(AppScreens.DetalleScreen.route +"/${mark.name}")
                }
            } catch (ex: Exception) {
                Log.d("ONCLICK", ""+ ex)
            }

        }
    )
}