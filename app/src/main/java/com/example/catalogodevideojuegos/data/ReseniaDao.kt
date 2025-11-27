package com.example.catalogodevideojuegos.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ReseniaDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(resenia: Resenia)
    @Update
    suspend fun update(resenia: Resenia)
    @Delete
    fun delete(resenia: Resenia)
    @Query("SELECT *  FROM resenia")
    fun getAll() : Flow<List<Resenia>>
}