package com.example.paging3.Dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paging3.model.UnsplashImage


@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM unsplash_image_table")
    fun getAllImages(): PagingSource<Int,UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(image: List<UnsplashImage>)

    @Query("DELETE FROM unsplash_image_table")
    suspend fun deleteAllImages()
}