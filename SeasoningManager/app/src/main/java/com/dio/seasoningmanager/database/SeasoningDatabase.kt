package com.dio.seasoningmanager.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dio.seasoningmanager.dao.SeasoningDataDao
import com.dio.seasoningmanager.entity.SeasoningData

@Database(entities = [SeasoningData::class], version = 1)
abstract class SeasoningDatabase : RoomDatabase() {
    abstract fun seasoningDao(): SeasoningDataDao
}