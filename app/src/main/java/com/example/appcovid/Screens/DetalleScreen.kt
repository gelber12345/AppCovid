package com.example.appcovid.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appcovid.model.MarkerMap

@Composable
fun DetalleScreen(navController: NavController, text :String?){
        Scaffold(
            modifier = Modifier.background(Color.Red),
            topBar = {
                TopAppBar() {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier.clickable{
                            navController.popBackStack()
                        })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "DETALLES CENTRO DE VACUNACION")
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
fun BodyDetalle(navController: NavController, mark: MarkerMap.Mark){


    Column (modifier = Modifier
        .fillMaxSize()
        .padding(20.dp, 16.dp)
        .border(5.dp, color = Color.LightGray, shape = RectangleShape)
        .background(Color(172, 238, 249))
        .padding(10.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "DETALLES CENTRO DE VACUNACION ${mark.name} \n")
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "DEPARTAMENTO : ${mark.dep} \n\n\n" +
                "HORARIO : ${mark.horario} \n\n\n" +
                "DIRECCION : ${mark.direc}")


    }

}