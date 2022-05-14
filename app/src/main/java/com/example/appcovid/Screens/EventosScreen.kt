package com.example.appcovid.Screens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.appcovid.R

private val eventosList: List<Eventos> = listOf(
    Eventos("VACUANCION EN HONORIO DELGADO" , "Se realizara una Vacunacion para Menores de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HONORIO DELGADO" , "Se realizara una Vacunacion para Menores de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad"),
    Eventos("VACUANCION EN HOSPITAL GOYONECHE" , "Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad Se realizara una Vacunacion para MAYORES de edad")

    )
@Composable
fun EventosScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "FUTUROS EVENTOS")

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
        Text("Eventos Proximos ")
        //Si existe el parametro se imprime

        MyList(eventosList)

    }

}
data class Eventos(val name:String , val description : String)

@Composable
fun MyList(platos: List<Eventos>){

    LazyColumn (){
        items(platos) { dish->
            MyComponent(dish)
        }
    }
}

@Composable
fun MyComponent(dish:Eventos){
    var expanded by remember { mutableStateOf(false)}
    Row(modifier = Modifier.padding(8.dp)) {

        Image(painterResource(id = R.drawable.ic_launcher_foreground),"Imagen prueba")
        Column( modifier = Modifier.clickable {
            expanded = !expanded
        }){
            Text(dish.name, maxLines = Int.MAX_VALUE)
            if (expanded) {
                Text(dish.description, maxLines = Int.MAX_VALUE)
            }else{
                Text(dish.description, maxLines = 1)
            }

        }

    }
}
