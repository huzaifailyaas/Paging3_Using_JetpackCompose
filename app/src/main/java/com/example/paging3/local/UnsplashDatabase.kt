package com.example.paging3.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging3.Dao.UnsplashImageDao
import com.example.paging3.Dao.UnsplashRemoteKeysDao
import com.example.paging3.model.UnsplashImage
import com.example.paging3.model.UnsplashRemoteKeys


@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {
    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}
