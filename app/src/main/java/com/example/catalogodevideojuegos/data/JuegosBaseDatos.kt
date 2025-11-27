package com.example.catalogodevideojuegos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Resenia::class], version = 1, exportSchema = false)
abstract class JuegosBaseDatos : RoomDatabase(){
    abstract fun reseniaDao(): ReseniaDao
    companion object{
        @Volatile
        private var Instance: JuegosBaseDatos? = null;

        fun getDatabase(context: Context): JuegosBaseDatos{

            return Instance?: synchronized(this) {
                Room.databaseBuilder(context, JuegosBaseDatos::class.java, "bd_juego")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also{Instance = it}
            }
        }
    }
}