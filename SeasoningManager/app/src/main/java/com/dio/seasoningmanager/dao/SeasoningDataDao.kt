package com.dio.seasoningmanager.dao

import androidx.room.*
import com.dio.seasoningmanager.entity.SeasoningData

@Dao
interface SeasoningDataDao {
    // 取得
    @Query("SELECT * FROM seasoning_data_table")
    fun getAll(): List<SeasoningData>
    // 挿入
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(seasoningData: SeasoningData)
    // 更新
    @Update
    fun update(seasoningData: SeasoningData)

    @Query("SELECT * FROM seasoning_data_table " + "WHERE uid = :uid")
    fun getSeasoningData(uid: Int): SeasoningData;
}