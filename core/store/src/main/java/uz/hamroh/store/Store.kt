package uz.hamroh.store

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class Store(
    private val context: Context,
    private val sharedPreferences: SharedPreferences,
): StoreRepository{
    private val token: Flow<String> = flowOf(KEY_TOKEN, "")
    private val email: Flow<String> = flowOf(KEY_USER_EMAIL, "")
    private val name: Flow<String> = flowOf(KEY_NAME, "")
    private val isFirstLaunch: Flow<Boolean> = flowOf(KEY_IS_FIRST_LAUNCH, true)

    override fun setToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }

    override fun getToken(): String? {
        return sharedPreferences.getString("token", "")
    }
    private fun <T> flowOf(
        key: Preferences.Key<T>,
        defaultValue: T,
    ): Flow<T> = context.dataStore.data.map { it[key] ?: defaultValue }

    private suspend inline fun edit(
        crossinline transform: suspend (MutablePreferences) -> Unit
    ) {
        context.dataStore.edit { transform(it) }
    }
    override suspend fun clearToken() = edit {
        it[KEY_TOKEN] = ""
    }

    override suspend fun setUserEmail(email: String) = edit {
        it[KEY_USER_EMAIL] = email
    }

    override suspend fun clearUserEmail()= edit {
        it[KEY_USER_EMAIL] = ""
    }

    override suspend fun getEmail(): String {
        return email.first()
    }
    override suspend fun setFirstLaunchState() = edit {
        it[KEY_IS_FIRST_LAUNCH] = false
    }

    override suspend fun isFirstLaunch(): Boolean {
        return isFirstLaunch.first()
    }

    override suspend fun setName(name: String) = edit {
        it[KEY_NAME] = name
    }

    override suspend fun getName(): String {
        return name.first()
    }

    override suspend fun onLogout() = edit {
        sharedPreferences.edit().clear().apply()
        it[KEY_TOKEN] = ""
        it[KEY_USER_EMAIL] = ""
        it[KEY_NAME] = ""
    }


    companion object {
        private const val STORE_NAME = "store"
        private val KEY_NAME = stringPreferencesKey("name")
        private val KEY_USER_EMAIL = stringPreferencesKey("email")
        private val KEY_TOKEN = stringPreferencesKey("token")
        private val KEY_IS_FIRST_LAUNCH = booleanPreferencesKey("isFirstLaunch")
        private val Context.dataStore by preferencesDataStore(name = STORE_NAME)
    }

}