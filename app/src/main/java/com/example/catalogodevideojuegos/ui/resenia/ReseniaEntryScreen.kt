package com.example.catalogodevideojuegos.ui.resenia

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catalogodevideojuegos.ui.AppViewModelProvider
import kotlinx.coroutines.launch


@Composable
fun ReseniaEntryScreen(
    // ViewModel se obtiene a través de la factoría de Compose
    viewModel: ReseniaEntryViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    // Para iniciar coroutines desde la UI (necesario para la función suspend 'saveResenia')
    val coroutineScope = rememberCoroutineScope()

    // Observa el estado del formulario que el ViewModel expone
    val estado = viewModel.reseniaUiState

    // Usamos Scaffold para asegurar que la pantalla se ve bien y maneja el relleno (padding)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ReseniaFormulario(
                estado = estado.reseniaDetails,
                onValueChange = viewModel::updateUiState,
                onSaveResenia = {
                    // Lanza la función suspend del ViewModel dentro del scope
                    coroutineScope.launch {
                        viewModel.saveResenia()
                        // Aquí puedes agregar navegación o un mensaje de éxito
                    }
                },
                isSaveEnabled = estado.isEntryValid
            )
        }

}

@Composable
fun ReseniaFormulario(
    estado: ReseniaDetails,
    onValueChange: (ReseniaDetails) -> Unit,
    onSaveResenia: () -> Unit,
    isSaveEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.6f))
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Escribe tu Reseña",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF17282D)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // --- Campo 1: Calificación (Numérico) ---
            OutlinedTextField(
                value = estado.calificacion,
                onValueChange = {
                    onValueChange(estado.copy(calificacion = it))
                },
                label = { Text("Calificación (0-10)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(Color(0xFF17282D))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // RESENIA
            OutlinedTextField(
                value = estado.contenido,
                onValueChange = {
                    onValueChange(estado.copy(contenido = it))
                },
                label = { Text("Tu Reseña/Contenido") },
                minLines = 3, // Para hacerlo más grande
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(Color(0xFF17282D))
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Guardar
            Button(
                onClick = onSaveResenia,
                enabled = isSaveEnabled, // Se habilita solo si el estado es válido
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF17282D))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Guardar",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text("Guardar Reseña")
            }
        }
    }
}

