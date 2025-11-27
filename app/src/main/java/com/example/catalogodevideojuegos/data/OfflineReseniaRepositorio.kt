package com.example.catalogodevideojuegos.data

import kotlinx.coroutines.flow.Flow

class OfflineReseniaRepositorio (private val reseniaDao: ReseniaDao): ReseniaRepositorio{
    override suspend fun insertResenia(resenia: Resenia) = reseniaDao.insert(resenia)

    override suspend fun updateResenia(resenia: Resenia) = reseniaDao.update(resenia)

    override fun deleteResenia(resenia: Resenia) = reseniaDao.delete(resenia)

    override fun getAllResenia(): Flow<List<Resenia>> = reseniaDao.getAll()

}