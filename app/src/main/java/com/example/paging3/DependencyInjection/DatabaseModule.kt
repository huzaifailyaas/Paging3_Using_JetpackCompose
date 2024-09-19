package com.example.paging3.DependencyInjection

import android.content.Context
import androidx.room.Room
import com.example.paging3.Util.Constants.UNSPLASH_DATABASE
import com.example.paging3.local.UnsplashDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UnsplashDatabase {
        return Room.databaseBuilder(
            context,
            UnsplashDatabase::class.java,
            UNSPLASH_DATABASE
        ).build()
    }
}