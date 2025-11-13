package com.example.catalogodevideojuegos.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.catalogodevideojuegos.R

@Composable
fun PantallaExpedition(navController: NavHostController) {
    val backgroundColor = Color(0xFF261706)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.logo_expedition),
            contentDescription = "logo umamusume",
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "Expedition 33",
            fontSize = 52.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
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
                "Clair Obscur: Expedition 33 es un innovador juego de rol por turnos con mecánicas en tiempo real únicas, que hacen que " +
                        " batallas sean más inmersivas y adictivas que nunca. Explora un mundo de fantasía inspirado en la Francia de la Belle " +
                        "Époque en el que lucharás contra rivales temibles.",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Justify

            )
        }
    }
}