package com.example.appcovid.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appcovid.model.MarkerMap

@Composable
fun DetalleScreen(navController: NavController, text: String?) {
    Scaffold(
        modifier = Modifier.background(Color.Red),
        topBar = {
            TopAppBar() {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "DETALLES DEL CENTRO DE VACUNACIÓN"
                )
            }
        },
    ) {
        text?.let {
            Card(modifier = Modifier.background(Color.Red)) {
                BodyDetalle(navController, MarkerMap.getMark(text))
            }
        }
    }
}

@Composable
fun BodyDetalle(navController: NavController, mark: MarkerMap.Mark) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 16.dp)
            .border(5.dp, color = Color(2,136,209), shape = RoundedCornerShape(8))
            .background(Color(179, 229, 252), shape = RoundedCornerShape(8))
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "CENTRO DE VACUNACIÓN: ${mark.nombre}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Departamento: ${mark.departamento} \n\n" +
                    "Horario: ${mark.horario} \n\n" +
                    "Dirección: ${mark.direccion}"
        )
    }
}