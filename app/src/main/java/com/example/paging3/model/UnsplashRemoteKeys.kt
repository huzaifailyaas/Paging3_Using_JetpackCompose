package com.example.paging3.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paging3.Util.Constants.UNSPLASH_REMOTE_KEYS_TABLE


@Entity(tableName =UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val prevPage:Int?,
    val nextPage:Int?
)
