package com.example.catalogodevideojuegos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catalogodevideojuegos.ui.theme.CatalogoDeVideojuegosTheme
import com.example.catalogodevideojuegos.ui.theme.PantallaUmaMusume

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
NavHost(
    navController = navController,
    startDestination = "pa  ntalla_principal"
){
    composable("pantalla_principal"){
        PantallaPrincipal(navController)
    }
    composable("juego_01_celeste"){
        PantallaCeleste(navController)
    }
    composable("juego_02_umamusume"){
        PantallaUmaMusume(navController)
    }
    }
}

@Composable
fun PantallaPrincipal(navController: NavHostController){

}
