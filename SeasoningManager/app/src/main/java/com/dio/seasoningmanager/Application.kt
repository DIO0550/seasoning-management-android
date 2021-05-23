package com.dio.seasoningmanager

import android.app.Application
import androidx.room.Room
import androidx.room.TypeConverters
import com.dio.seasoningmanager.const.SeasoningManagerConst
import com.dio.seasoningmanager.converter.DateConverter
import com.dio.seasoningmanager.database.SeasoningDatabase

class Application : Application() {
    companion object {
        lateinit var database: SeasoningDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            SeasoningDatabase::class.java,
            SeasoningManagerConst.Database.DB_NAME
        ).build()
    }
}