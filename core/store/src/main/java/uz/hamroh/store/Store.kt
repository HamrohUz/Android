package uz.hamroh.store

import android.content.Context
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map

class Store(
    private val context: Context,
): StoreRepository{

    val token: Flow<String> = flowOf(KEY_TOKEN, "")
    private fun <T> flowOf(
        key: Preferences.Key<T>,
        defaultValue: T,
    ): Flow<T> = context.dataStore.data.map { it[key] ?: defaultValue }

    private suspend inline fun edit(
        crossinline transform: suspend (MutablePreferences) -> Unit
    ) {
        context.dataStore.edit { transform(it) }
    }

    override suspend fun setToken(token: String) = edit {
        it[KEY_TOKEN] = token
    }

    override suspend fun getToken(): String {
        return token.first()
    }

    override suspend fun clearToken() = edit {
        it[KEY_TOKEN] = ""
    }

    companion object {
        private const val STORE_NAME = "store"

        private val KEY_TOKEN = stringPreferencesKey("token")
        private val Context.dataStore by preferencesDataStore(name = STORE_NAME)
    }

}