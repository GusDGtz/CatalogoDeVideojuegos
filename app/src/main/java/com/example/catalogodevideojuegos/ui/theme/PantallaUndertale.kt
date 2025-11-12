package com.example.catalogodevideojuegos.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.catalogodevideojuegos.R

@Composable
fun PantallaUndertale(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.hsv(240F,.3F, .13F)).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.logo_undertale),
            contentDescription = "logo undertale",
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "UNDERTALE",
            fontSize = 64.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier.background(Color.Black)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Text(
                "Descripción",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Es un videojuego de rol en 2D de 2015 creado por el desarrollador independiente estadounidense Toby Fox. \nEl jugador controla a un niño que ha caído al subsuelo: una gran región aislada bajo la superficie de la Tierra, separada por una barrera mágica. \nEl jugador se encuentra con varios monstruos durante su viaje de regreso a la superficie, aunque algunos monstruos pueden involucrar al jugador en una pelea. \nEl sistema de combate involucra al jugador navegando a través de los ataques mini bullet hell por parte del oponente.",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}