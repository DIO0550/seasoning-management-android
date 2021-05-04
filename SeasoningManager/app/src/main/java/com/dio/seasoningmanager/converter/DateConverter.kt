package com.dio.seasoningmanager.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    // Date型をLong型に変換
    @TypeConverter
    fun dateToLong(date: Date?): Long? {
        return date?.let { it.time }
    }
}