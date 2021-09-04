package com.dio.seasoningmanager

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverters
import com.dio.seasoningmanager.Application.Companion.getApplication
import com.dio.seasoningmanager.const.SeasoningManagerConst
import com.dio.seasoningmanager.converter.DateConverter
import com.dio.seasoningmanager.database.SeasoningDatabase

class Application : Application() {
    companion object {
        lateinit var database: SeasoningDatabase
        private var application: com.dio.seasoningmanager.Application? = null;

        /**
         * applicationのgetter
         */
        public fun getApplication(): com.dio.seasoningmanager.Application? {
            return application;
        }

        /**
         * contextのgetter
         */
        public fun getContext(): Context? {
            return com.dio.seasoningmanager.Application.getApplication()?.getApplicationContext()
        }
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            SeasoningDatabase::class.java,
            SeasoningManagerConst.Database.DB_NAME
        ).build()
        application = this;
    }
}