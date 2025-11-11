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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.catalogodevideojuegos.R

@Composable
fun PantallaUmaMusume(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.hsv(90F,.3F, .13F)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.logo_umamusume),
            contentDescription = "logo undertale",
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "UmaMusume",
            fontSize = 52.sp,
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
                "Uma Musume Pretty Derby es una franquicia multimedia que presenta un " +
                        "mundo antropomorfo de chicas-caballo que estudian en una academia y entrenan " +
                        "intensamente para competir en carreras. La historia sigue a Uma Musume, que heredan " +
                        "los nombres de caballos de otro mundo y siguen corriendo hacia sus metas.",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}