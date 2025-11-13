package com.example.catalogodevideojuegos

import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.catalogodevideojuegos.ui.theme.CatalogoDeVideojuegosTheme
import com.example.catalogodevideojuegos.ui.theme.PantallaCeleste
import com.example.catalogodevideojuegos.ui.theme.PantallaExpedition
import com.example.catalogodevideojuegos.ui.theme.PantallaOmori
import com.example.catalogodevideojuegos.ui.theme.PantallaUmaMusume
import com.example.catalogodevideojuegos.ui.theme.PantallaUndertale
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants

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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    containerColor = Color.hsv(105F,.30F,.85F),
                    contentColor = Color.DarkGray.copy(alpha = .75F),
                    elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                ){
                    Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Menu")
                    Text("Lista de Videojuegos")

                }
            },
            floatingActionButtonPosition = FabPosition.Start
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

@Composable
fun PantallaPrincipal(navController: NavHostController){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().background(Color.hsv(90F,.3F, .13F))
        ){
            Text(
                text="Catalogo de Videojuegos",
                fontSize = 48.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 48.dp, horizontal = 20.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize().padding(96.dp)
            ){
                Text(
                    text="- Recomendados -",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
                Button(
                    onClick ={
                        navController.navigate("juego_01_celeste")
                    },
                    modifier = Modifier.width(300.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(105F,0F,.2F)),
                    shape = RoundedCornerShape(8.dp)
                ){
                    Text(
                        text = "Celeste"
                    )
                }
                Button(
                    onClick ={
                        navController.navigate("juego_02_umamusume")
                    },
                    modifier = Modifier.width(300.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(105F,0F,.2F)),
                    shape = RoundedCornerShape(8.dp)
                ){
                    Text(
                        text = "Umamusume"
                    )
                }
            }
        }
}

@Preview
@Composable
fun PreviewCatalogo(){
    MyApp()
}
