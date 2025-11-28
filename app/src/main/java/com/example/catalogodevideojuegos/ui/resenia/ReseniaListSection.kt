package com.example.catalogodevideojuegos.ui.resenia

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catalogodevideojuegos.data.Resenia
import com.example.catalogodevideojuegos.ui.AppViewModelProvider

@Composable
fun ReseniaListSection(
    // Inyección de la Factoría (asumimos que tienes la Factoría real)
    viewModel: ReseniaListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    // Observa el StateFlow: la lista se actualiza automáticamente
    val resenias by viewModel.listaResenias.collectAsState()

    // Contenedor principal para la sección, que usará el scroll del padre
    Column(
        modifier = Modifier
            .fillMaxWidth() // Usa todo el ancho disponible del padre
            .padding(horizontal = 16.dp, vertical = 8.dp), // Padding para la sección
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Reseñas",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        if (resenias.isEmpty()) {
            Text(
                text = "Aún no hay reseñas. ¡Sé el primero en agregar una!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            // *** CAMBIO CLAVE: Usamos Column en lugar de LazyColumn ***
            // Iteramos sobre todos los elementos con forEach.
            // El scroll lo maneja el padre (la pantalla principal).
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                resenias.forEach { resenia ->
                    ReseniaItem(resenia = resenia)
                }
            }
        }
    }
}

@Composable
fun ReseniaItem(resenia: Resenia, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.60f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Calificación: ${resenia.calificacion}/10",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF17282D)
            )
            Text(
                text = resenia.contenido,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "ID: ${resenia.id}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}