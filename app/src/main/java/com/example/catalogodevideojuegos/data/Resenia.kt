package com.example.catalogodevideojuegos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resenia")
data class Resenia(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val calificacion: Int,
    val contenido: String
)