package com.example.catalogodevideojuegos.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaOmori(navController: NavHostController) {
    val backgroundColor = Color(0xFF000000)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles del Juego", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundColor)
            )
        },
        containerColor = backgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo_omori),
                contentDescription = "logo omori",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Omori",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 18.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.15f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Descripción",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Omori es un videojuego de terror psicológico y surrealista que explora temas como la ansiedad, la depresión y el trauma. El jugador controla a un chico hikikomori" +
                                "llamado Sunny y a su alter-ego en el mundo de los sueños, Omori; que exploran ambos mundos con el objetivo de vencer sus miedos y descubrir secretos. El juego comienza " +
                                "con el personaje principal, Omori, despertando en WHITE SPACE, una habitación donde ha vivido \"desde que tiene memoria\". Al cruzar la única puerta allí, entra al mundo " +
                                "de HEADSPACE, donde se hallan sus amigos Aubrey, Kel, Hero, Basil y su hermana mayor, Mari.",
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Justify

                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}