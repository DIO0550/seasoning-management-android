package com.dio.seasoningmanager.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dio.seasoningmanager.converter.DateConverter
import java.util.*

@Entity(tableName = "seasoning_data_table")
@TypeConverters(DateConverter::class)
data class SeasoningData(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "expiration_date") val expirationDate: Date,
    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB)  val image: ByteArray
)