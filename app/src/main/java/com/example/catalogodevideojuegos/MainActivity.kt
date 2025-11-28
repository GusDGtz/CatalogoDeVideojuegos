package com.example.catalogodevideojuegos

import android.R.attr.fontWeight
import android.R.attr.text
import android.R.attr.title
import android.app.Application
import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catalogodevideojuegos.data.AppContainer
import com.example.catalogodevideojuegos.data.AppDataContainer
import com.example.catalogodevideojuegos.ui.theme.CatalogoDeVideojuegosTheme
import com.example.catalogodevideojuegos.ui.theme.PantallaCeleste
import com.example.catalogodevideojuegos.ui.theme.PantallaExpedition
import com.example.catalogodevideojuegos.ui.theme.PantallaMundosCeleste
import com.example.catalogodevideojuegos.ui.theme.PantallaOmori
import com.example.catalogodevideojuegos.ui.theme.PantallaUmaMusume
import com.example.catalogodevideojuegos.ui.theme.PantallaUndertale
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val backgroundColor = Color(0xFF2A2A2A)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContentColor = Color.White,
                drawerContainerColor = Color.hsv(105F,0F,.2F),
            ){
                Column(
                    modifier = Modifier.padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ){
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "Lista de Videojuegos",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(6.dp))
                    HorizontalDivider(Modifier.height(12.dp))
                    NavigationDrawerItem(
                        label = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ){
                                Icon(Icons.Filled.Home, contentDescription = "Inicio", tint = Color.White)
                                Text(
                                    text = "   Inicio",
                                    color = Color.White,
                                    fontSize = 24.sp
                                )

                            }
                        },
                        selected = false,
                        onClick = {navController.navigate("pantalla_principal")}
                    )

                    NavigationDrawerItem(
                        label = {Text("🍓 Celeste",
                            color = Color.White,
                            fontSize = 24.sp)},
                        selected = false,
                        onClick = {navController.navigate("juego_01_celeste")}
                    )
                    NavigationDrawerItem(
                        label = {Text("🐎 Umamusume",
                            color = Color.White,
                            fontSize = 24.sp)},
                        selected = false,
                        onClick = {navController.navigate("juego_02_umamusume")}
                    )
                    NavigationDrawerItem(
                        label = {Text("💀 Undertale",
                            color = Color.White,
                            fontSize = 24.sp)},
                        selected = false,
                        onClick = {navController.navigate("juego_03_undertale")}
                    )
                    NavigationDrawerItem(
                        label = {Text("🔪 Omori",
                            color = Color.White,
                            fontSize = 24.sp)},
                        selected = false,
                        onClick = {navController.navigate("juego_04_omori")}
                    )
                    NavigationDrawerItem(
                        label = {Text("🗼 Expedition 33",
                            color = Color.White,
                            fontSize = 24.sp)},
                        selected = false,
                        onClick = {navController.navigate("juego_05_expedition")}
                    )
                }
            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Lista de Videojuegos", color = Color.White) },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if(isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.List,
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
            NavHost(
                navController = navController,
                startDestination = "pantalla_principal",
                modifier = Modifier.padding(paddingValues)
            ){
                composable("pantalla_principal"){
                    PantallaPrincipal(navController)
                }
                composable("juego_01_celeste"){
                    PantallaCeleste(navController)
                }
                composable("juego_01_celeste_0"){
                    PantallaMundosCeleste(navController)
                }
                composable("juego_02_umamusume"){
                    PantallaUmaMusume(navController)
                }
                composable("juego_03_undertale"){
                    PantallaUndertale(navController)
                }
                composable("juego_04_omori"){
                    PantallaOmori(navController)
                }
                composable("juego_05_expedition"){
                    PantallaExpedition(navController)
                }
            }
        }
    }
}
data class Juego(val nombre: String, @DrawableRes val imagenResId: Int, val autor: String, val fecha: String){

}

@Composable
fun PantallaPrincipal(navController: NavHostController) {
    val juegos = listOf(
        Juego("Celeste", R.drawable.fondo_celeste_card, "Maddy Thorson", "2018"),
        Juego("Umamusume", R.drawable.imagen_juego_umamusume, "Kosugi", "2021"),
        Juego("Undertale", R.drawable.imagen_juego_undetale, "Toby Fox", "2015"),
        Juego("Omori", R.drawable.imagen_juego_omori, "OMOCAT", "2020"),
        Juego("Expedition 33", R.drawable.imagen_juego_exp, "François Meurisse", "2025")
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E0E))
    ) {
        Text(
            text = "Catalogo de Videojuegos",
            fontSize = 48.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 48.dp, horizontal = 20.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                // --- CORRECCIÓN 1: Eliminar el background incorrecto ---
                // Se elimina el .background(Image(...)) que no es válido.
                .padding(8.dp)
        ) {
            items(juegos) { juego ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Añadimos una altura para que la imagen se vea
                        .padding(6.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    // Hacemos el color del contenedor transparente para que se vea la imagen
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    // --- CORRECCIÓN 2: Usar Box para apilar elementos ---
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // 1. IMAGEN DE FONDO
                        Image(
                            painter = painterResource(id = juego.imagenResId),
                            contentDescription = "Fondo de ${juego.nombre + juego.autor + juego.fecha}",
                            modifier = Modifier.matchParentSize(), // Ocupa todo el Box/Card
                            contentScale = ContentScale.Crop // Asegura que la imagen cubra el área
                        )

                        // 2. SCRIM (Capa semi-transparente para legibilidad)
                        // Esto hace que el texto sea más fácil de leer sobre la imagen.
                        Spacer(
                            modifier = Modifier
                                .matchParentSize()
                                .background(Color.Black.copy(alpha = 0.5f))
                        )

                        // 3. CONTENIDO ORIGINAL (TEXTO)
                        // Mantenemos la estructura original (Row > Column > Text) pero ajustamos colores.
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize(), // Rellenar para poder posicionar
                            verticalAlignment = Alignment.Bottom // Posicionar texto abajo
                        ) {
                            Column {
                                Text(
                                    text = juego.nombre,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 36.sp, // Aumentado para mejor lectura en banner
                                    color = Color.White // Texto blanco para contraste con el scrim
                                )
                                Text(
                                    text = juego.autor,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 22.sp, // Aumentado para mejor lectura en banner
                                    color = Color.White // Texto blanco para contraste con el scrim
                                )
                                Text(
                                    text = juego.fecha,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 22.sp, // Aumentado para mejor lectura en banner
                                    color = Color.White // Texto blanco para contraste con el scrim
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

class CatalogoApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}

@Preview
@Composable
fun PreviewCatalogo(){
    MyApp()
}