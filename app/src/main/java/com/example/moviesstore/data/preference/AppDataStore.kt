package com.example.moviesstore.data.preference

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.moviesstore.model.User
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

val exceptionHandler: suspend (kotlinx.coroutines.flow.FlowCollector<Preferences>, Throwable) -> Unit =
    { flowCollector, exception ->
        if (exception is IOException) {
            flowCollector.emit(emptyPreferences())
        } else {
            throw exception
        }
    }


val gson = Gson()


@Singleton
class AppDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val scope = CoroutineScope(Job())
    private val userDataKey = stringPreferencesKey("user data")
    private val Context.dataStore by preferencesDataStore(name = "pref")

    private val watchlistDataKey = stringPreferencesKey("watchlist")

    val userInfo: Flow<User?> = context.dataStore.data.catch(exceptionHandler).map{
        it[userDataKey]?.let {
            gson.fromJson(it,User::class.java)
        }
    }

    val watchlist: Flow<List<Int>?> = context.dataStore.data.catch(exceptionHandler).map{
        it[watchlistDataKey]?.let {
            it.split(',').map{
                it.toInt()
            }
        }
    }

    fun storeUserData(user: User) = scope.launch {
        context.dataStore.edit {
            it[userDataKey] =  gson.toJson(user)
        }
    }

    fun storeMovieInWatchlist(id:Int) = scope.launch {
        context.dataStore.edit {
            it[watchlistDataKey]?.let{ nums->
                it[watchlistDataKey] = "$nums,$id"
            } ?: run{
                it[watchlistDataKey] =  id.toString()
            }

        }
    }
    fun logout() = scope.launch {
        context.dataStore.edit {
            it[userDataKey] = ""
            it[watchlistDataKey] = ""
        }
    }
}