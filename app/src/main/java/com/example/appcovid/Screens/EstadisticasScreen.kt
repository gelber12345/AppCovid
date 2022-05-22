package com.example.appcovid.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.appcovid.model.Estadisticas

@Composable
fun EventosScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "DATOS ESTADÍSTICOS POR DISTRITO")
            }
        }
    ) {
        BodyEventos(navController)
    }
}

@Composable
fun BodyEventos(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text("Datos Estadisticos ") // Redundancia con el titulo superior
        Text(text = "")
        //Si existe el parametro se imprime
        MyList(Estadisticas.getList())
    }
}

data class Eventos(val name: String, val description: String)

@Composable
fun MyList(datos: MutableList<Estadisticas.Estadistica>) {
    LazyColumn() {
        items(datos) { dato ->
            MyComponent(dato)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun MyComponent(dato: Estadisticas.Estadistica) {
    var expanded by remember { mutableStateOf(false) }
    Card {
        Row(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 10.dp, bottom = 10.dp)
                .background(Color(179, 229, 252))
                .fillMaxWidth()
                .clickable {
                    expanded = !expanded
                }
                .padding(10.dp)

        ) {
            Image(
                painterResource(id = dato.img),
                "Imagen prueba",
                modifier = Modifier.padding(8.dp)
            )
            Column {
                Text(
                    text = dato.nombreDistrito,
                    maxLines = Int.MAX_VALUE,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                if (expanded) {
                    Text(
                        text = "Datos Estadísticos",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                    )
                    Text(
                        text = "Casos Positivos(vivos): ${dato.casosPositivosVivos} \n" +
                                "Casos Positivos(defunción): ${dato.casosPositivosDefuncion} \n" +
                                "Casos Negativos: ${dato.casosNegativos} \n" +
                                "Resultados Pendientes: ${dato.casosResultadosPendientes} \n" +
                                "Total: ${dato.totalCasos}", maxLines = Int.MAX_VALUE,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                } else {
                    Text(
                        text = "... Más informacion",
                        maxLines = 1,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}
