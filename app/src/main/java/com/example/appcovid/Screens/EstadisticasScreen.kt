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
import com.example.appcovid.model.Estadisticas


@Composable
fun EventosScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "DATOS ESTADISTICOS ")

            }
        }
    ) {
        BodyEventos(navController)
    }
}
@Composable
fun BodyEventos(navController: NavController){

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Datos Estadisticos ")
        //Si existe el parametro se imprime
            MyList(Estadisticas.getList())

    }

}
data class Eventos(val name:String , val description : String)

@Composable
fun MyList(datos: MutableList<Estadisticas.Estadistica>){

    LazyColumn (){
        items(datos) { dato->
            MyComponent(dato)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun MyComponent(dato: Estadisticas.Estadistica){
    var expanded by remember { mutableStateOf(false)}
    Card() {
        Row(modifier = Modifier
            .padding(8.dp)
            .background(Color(158, 235, 249))) {

            Image(painterResource(id = dato.img),"Imagen prueba")
            Column( modifier = Modifier.clickable {
                expanded = !expanded
            }){
                Text(dato.provincia, maxLines = Int.MAX_VALUE)
                if (expanded) {
                    Text(text = "DATOS ESTADISTICOS :\n" +
                            "CASOS POSITIVOS VIVOS: ${dato.posv} \n" +
                            "CASOS POSITIVOS DEFUNTOS : ${dato.posm} \n" +
                            "CASOS NEGATIVOS : ${dato.nega} \n" +
                            "PENDIENTES  : ${dato.pendientes} \n" +
                            "TOTAL : ${dato.total}", maxLines = Int.MAX_VALUE)
                }else{
                    Text(text = "DATOS ESTADISTICOS :\n" +
                            "CASOS POSITIVOS VIVOS: ${dato.posv} \n" +
                            "CASOS POSITIVOS DEFUNTOS : ${dato.posm} \n" +
                            "CASOS NEGATIVOS : ${dato.nega} \n" +
                            "PENDIENTES  : ${dato.pendientes} \n" +
                            "TOTAL : ${dato.total}", maxLines = 1)
                }

            }
        }
    }
}
