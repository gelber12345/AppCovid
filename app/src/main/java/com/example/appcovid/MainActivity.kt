package com.example.appcovid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.appcovid.Navigation.AppNavigation
import com.example.appcovid.Navigation.AppScreens
import com.example.appcovid.Screens.Componens.ButtomNavigationBar
import com.example.appcovid.Screens.FirstScreen
import com.example.appcovid.ui.theme.AppCovidTheme
import com.google.maps.android.compose.GoogleMap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCovidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main()

                }
            }
        }
    }
}
@Composable
fun Main(){
    val navController = rememberNavController()
    val navigationItems= listOf(
        AppScreens.FirstScreen ,
        AppScreens.EventosScreen
    )
    Scaffold(
        bottomBar = {ButtomNavigationBar(navController = navController, items = navigationItems)}
    ) {
            innerPadding ->
        // Apply the padding globally to the whole BottomNavScreensController
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavigation(navController)
        }




    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppCovidTheme {
        Greeting("Android")
    }
}