package io.narendra.demo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.narendra.demo.data.GenreConverters
import io.narendra.demo.model.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}