package com.example.catalogodevideojuegos.ui.resenia

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.catalogodevideojuegos.data.Resenia
import com.example.catalogodevideojuegos.data.ReseniaRepositorio

class ReseniaEntryViewModel(private val reseniaRepositorio: ReseniaRepositorio) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var reseniaUiState by mutableStateOf(ReseniaUiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(reseniaDetails: ReseniaDetails) {
        reseniaUiState =
            ReseniaUiState(reseniaDetails = reseniaDetails, isEntryValid = validateInput(reseniaDetails))
    }

    suspend fun saveResenia() {
        if (validateInput()) {
            reseniaRepositorio.insertResenia(reseniaUiState.reseniaDetails.toResenia())
        }
    }

    private fun validateInput(uiState: ReseniaDetails = reseniaUiState.reseniaDetails): Boolean {
        return with(uiState) {
            calificacion.isNotBlank() && contenido.isNotBlank()
        }
    }
}

data class ReseniaUiState(
    val reseniaDetails: ReseniaDetails = ReseniaDetails(),
    val isEntryValid: Boolean = false
)

data class ReseniaDetails(
    val id: Int = 0,
    val calificacion: String = "",
    val contenido: String = "",
)

fun ReseniaDetails.toResenia(): Resenia = Resenia(
    id = id,
    calificacion = calificacion.toIntOrNull() ?: 0,
    contenido = contenido
)

fun Resenia.toItemUiState(isEntryValid: Boolean = false): ReseniaUiState = ReseniaUiState(
    reseniaDetails = this.toReseniaDetails(),
    isEntryValid = isEntryValid
)

fun Resenia.toReseniaDetails(): ReseniaDetails = ReseniaDetails(
    id = id,
    calificacion = calificacion.toString(),
    contenido = contenido
)
