package com.example.catalogodevideojuegos.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface ReseniaRepositorio {

    suspend fun insertResenia(resenia: Resenia)

    suspend fun updateResenia(resenia: Resenia)

    fun deleteResenia(resenia: Resenia)

    fun getAllResenia() : Flow<List<Resenia>>

    fun getResenia(id: Int): Flow<Resenia>
}