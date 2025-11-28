package com.example.catalogodevideojuegos.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.catalogodevideojuegos.CatalogoApplication
import com.example.catalogodevideojuegos.ui.home.HomeViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            ReseniaEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.reseniaRepositorio
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            _root_ide_package_.com.example.catalogodevideojuegos.ui.resenia.ReseniaEntryViewModel(
                inventoryApplication().container.reseniaRepositorio
            )
        }

        /* Initializer for ItemDetailsViewModel
        initializer {
            ReseniaDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.reseniaRepositorio
            )
        }
        */

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(inventoryApplication().container.reseniaRepositorio)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): CatalogoApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as CatalogoApplication)
