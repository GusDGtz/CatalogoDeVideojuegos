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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.catalogodevideojuegos.R

@Composable
fun PantallaCeleste(navController : NavController){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.hsv(240F,.3F, .20F)).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.logo_celeste),
            contentDescription = "logo celeste",
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "CELESTE",
            fontSize = 64.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.hsv(195f, .43f, .75f)
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
                "Celeste es un videojuego perteneciente al género de plataformas creado por los desarrolladores de videojuegos canadienses Maddy Thorson y Noel Berry. \nEl videojuego fue creado originalmente como un prototipo en cuatro días durante un game jam, y más tarde se expandió a un lanzamiento completo. \nCeleste se lanzó en enero de 2018 para las plataformas Microsoft Windows, Nintendo Switch, PlayStation 4, Xbox One, macOS y GNU/Linux.",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}