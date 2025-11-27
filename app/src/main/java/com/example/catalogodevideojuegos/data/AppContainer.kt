package com.example.catalogodevideojuegos.data

import android.content.Context

interface AppContainer {
    val reseniaRepositorio : ReseniaRepositorio
}

class AppDataContainer (private val context: Context) : AppContainer{
    override val reseniaRepositorio: ReseniaRepositorio by lazy {
        OfflineReseniaRepositorio(JuegosBaseDatos.getDatabase(context).reseniaDao())
    }
}