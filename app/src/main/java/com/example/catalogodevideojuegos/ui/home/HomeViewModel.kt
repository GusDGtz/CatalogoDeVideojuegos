package com.example.catalogodevideojuegos.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogodevideojuegos.data.Resenia
import com.example.catalogodevideojuegos.data.ReseniaRepositorio
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * ViewModel to retrieve all resenias in the Room database.
 */
class HomeViewModel(private val reseniaRepositorio: ReseniaRepositorio) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> =
        reseniaRepositorio.getAllResenia().map {HomeUiState(it)}
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(val reseniaList: List<Resenia> = listOf())
