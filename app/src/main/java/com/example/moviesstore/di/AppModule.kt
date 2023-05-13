package com.example.moviesstore.di

import android.content.Context
import com.example.moviesstore.data.preference.AppDataStore
import com.example.moviesstore.data.repository.LoginRepository
import com.example.moviesstore.data.repository.MainRepository
import com.example.moviesstore.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRepo(application: BaseApplication) =
        MainRepository(application)

    @Singleton
    @Provides
    fun provideLoginRepo( appDataStore: AppDataStore) =
        LoginRepository(appDataStore)
}