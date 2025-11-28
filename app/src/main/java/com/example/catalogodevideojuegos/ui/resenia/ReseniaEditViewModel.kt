package com.example.catalogodevideojuegos.ui.resenia

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogodevideojuegos.data.ReseniaRepositorio
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ReseniaEditViewModel (
    savedStateHandle: SavedStateHandle,
    private val reseniaRepositorio: ReseniaRepositorio
) : ViewModel() {

    var reseniaUiState by mutableStateOf(ReseniaUiState())
        private set

    private val reseniaId: Int = checkNotNull(savedStateHandle[ReseniaEditDestination.ITEM_ID_ARG])

    init {
        viewModelScope.launch {
            reseniaUiState = reseniaRepositorio.getResenia(reseniaId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }

    suspend fun updateItem() {
        if (validateInput(reseniaUiState.reseniaDetails)) {
            reseniaRepositorio.updateResenia(reseniaUiState.reseniaDetails.toResenia())
        }
    }

    fun updateUiState(reseniaDetails: ReseniaDetails) {
        reseniaUiState =
            ReseniaUiState(reseniaDetails = reseniaDetails, isEntryValid = validateInput(reseniaDetails))
    }

    private fun validateInput(uiState: ReseniaDetails = reseniaUiState.reseniaDetails): Boolean {
        return with(uiState) {
            contenido.isNotBlank() && calificacion.isNotBlank()
        }
    }
}