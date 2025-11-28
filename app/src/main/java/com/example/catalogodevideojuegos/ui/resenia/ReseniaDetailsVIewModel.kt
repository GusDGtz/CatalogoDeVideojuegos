package com.example.catalogodevideojuegos.ui.resenia

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogodevideojuegos.data.ReseniaRepositorio
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
/*
class ReseniaDetailsVIewModel (
        savedStateHandle: SavedStateHandle,
        private val reseniaRepositorio: ReseniaRepositorio
    ) : ViewModel() {

        private val reseniaId: Int = checkNotNull(savedStateHandle[ReseniaDetailsDestination.itemIdArg])

        /**
         * uiState: Mantiene el estado de los detalles del Item.
         * Escucha el flujo de la BD y lo convierte a ItemDetailsUiState.
         */
        val uiState: StateFlow<com.example.inventory.ui.item.ItemDetailsUiState> =
            itemsRepository.getItemStream(itemId)
                .filterNotNull()
                .map {
                    ItemDetailsUiState(outOfStock = it.quantity <= 0, itemDetails = it.toItemDetails())
                }.stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = ItemDetailsUiState()
                )

        // Función para reducir la cantidad en 1
        fun reduceQuantityByOne() {
            viewModelScope.launch {
                val currentItem = uiState.value.itemDetails.toItem()
                if (currentItem.quantity > 0) {
                    itemsRepository.updateItem(currentItem.copy(quantity = currentItem.quantity - 1))
                }
            }
        }

        // Función para eliminar el ítem
        suspend fun deleteItem() {
            itemsRepository.deleteItem(uiState.value.itemDetails.toItem())
        }

        companion object {
            private const val TIMEOUT_MILLIS = 5_000L
        }
    }

    /**
     * UI state for ItemDetailsScreen
     */
    data class ItemDetailsUiState(
        val outOfStock: Boolean = true,
        val itemDetails: ItemDetails = ItemDetails()
    )
*/