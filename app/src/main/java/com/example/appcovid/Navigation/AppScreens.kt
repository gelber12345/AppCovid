package com.example.appcovid.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreens(
    val route : String,
    val title : String,
    val icon : ImageVector

    ){
    object FirstScreen : AppScreens ("first_screen","Mapa", Icons.Filled.Home)
    object DetalleScreen : AppScreens ("detalle_screen","Eventos", Icons.Filled.Email)
    object EstadisticasScreen : AppScreens ("estadisticas_screen","Detalle", Icons.Filled.Email)
}
