package uz.hamroh.store

interface StoreRepository {
    fun setToken(token: String)
    fun getToken(): String?
    suspend fun clearToken()
    suspend fun setUserEmail(email: String)
    suspend fun getEmail(): String
    suspend fun clearUserEmail()
    suspend fun setFirstLaunchState()
    suspend fun isFirstLaunch(): Boolean
    suspend fun setName(name: String)
    suspend fun getName(): String
    suspend fun onLogout()
}