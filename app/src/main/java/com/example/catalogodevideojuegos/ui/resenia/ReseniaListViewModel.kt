package com.example.catalogodevideojuegos.ui.resenia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogodevideojuegos.data.Resenia
import com.example.catalogodevideojuegos.data.ReseniaRepositorio
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ReseniaListViewModel(private val reseniaRepositorio: ReseniaRepositorio) : ViewModel() {

    // *** ESTADO DE LA LISTA ***
    // 1. Recoge el Flow del Repositorio.
    // 2. Lo convierte en un StateFlow que es observado por Compose.
    val listaResenias: StateFlow<List<Resenia>> = reseniaRepositorio.getAllResenia()
        .stateIn(
            scope = viewModelScope,
            // Permanece activo mientras haya observadores, con un timeout de 5s
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList() // Valor inicial para evitar nulos
        )
}