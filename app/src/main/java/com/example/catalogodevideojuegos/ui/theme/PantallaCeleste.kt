package com.example.catalogodevideojuegos.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import com.example.catalogodevideojuegos.R

data class MundoCeleste(val id: String, val nombre: String, val dificultad: String)

@Composable
fun TarjetaMundoCeleste(mundoCeleste: MundoCeleste){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            //Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = mundoCeleste.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = mundoCeleste.dificultad,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaCeleste(navController : NavController){
    val backgroundColor = Color.hsv(240F,.3F, .20F)
    val titleColor = Color.hsv(195f, .43f, .75f)




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
                painter = painterResource(R.drawable.logo_celeste),
                contentDescription = "logo celeste",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "CELESTE",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = titleColor,
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
                        "Celeste es un videojuego perteneciente al género de plataformas creado por los desarrolladores de videojuegos canadienses Maddy Thorson y Noel Berry. \n" +
                                "El videojuego fue creado originalmente como un prototipo en cuatro días durante un game jam, y más tarde se expandió a un lanzamiento completo. \n" +
                                "Celeste se lanzó en enero de 2018 para las plataformas Microsoft Windows, Nintendo Switch, PlayStation 4, Xbox One, macOS y GNU/Linux.",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Justify

                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {navController.navigate("juego_01_celeste_0"){
                    launchSingleTop = true
                }
                }
            ){
                Text("Lista de Niveles")
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaMundosCeleste(navController: NavController){

    // PARA LAZY COLUMN
    val mundosCeleste = listOf(
        MundoCeleste("1-A", "Forsaken City", "1/10"),
        MundoCeleste("2-A", "Old Site", "2/10"),
        MundoCeleste("3-A", "Celestial Resort", "3/10"),
        MundoCeleste("4-A", "Golden Ridge", "3/10"),
        MundoCeleste("5-A", "Mirror Temple", "4/10"),
        MundoCeleste("6-A", "Reflection", "5/10"),
        MundoCeleste("7-A", "The Summit", "6/10"),
        MundoCeleste("8-A", "Core", "7/10"),
        MundoCeleste("1-B", "Forsaken City (B-Side)", "4/10"),
        MundoCeleste("2-B", "Old Site (B-Side)", "5/10"),
        MundoCeleste("3-B", "Celestial Resort (B-Side)", "6/10"),
        MundoCeleste("4-B", "Golden Ridge (B-Side)", "6/10"),
        MundoCeleste("5-B", "Mirror Temple (B-Side)", "7/10"),
        MundoCeleste("6-B", "Reflection (B-Side)", "8/10"),
        MundoCeleste("7-B", "The Summit (B-Side)", "9/10"),
        MundoCeleste("8-B", "Core (B-Side)", "9/10"),
        MundoCeleste("1-C", "Forsaken City (C-Side)", "6/10"),
        MundoCeleste("2-C", "Old Site (C-Side)", "6/10"),
        MundoCeleste("3-C", "Celestial Resort (C-Side)", "7/10"),
        MundoCeleste("4-C", "Golden Ridge (C-Side)", "7/10"),
        MundoCeleste("5-C", "Mirror Temple (C-Side)", "8/10"),
        MundoCeleste("6-C", "Reflection (C-Side)", "8/10"),
        MundoCeleste("7-C", "The Summit (C-Side)", "10/10"),
        MundoCeleste("8-C", "Core (C-Side)", "10/10"),
        MundoCeleste("9-A", "Farewell", "10/10"),
    )

    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
    ){
        items(mundosCeleste) {
                mundoCeleste ->
            TarjetaMundoCeleste(mundoCeleste)
        }
    }
}

