package uz.hamroh.store

interface StoreRepository {
    suspend fun setToken(token: String)
    suspend fun getToken(): String
    suspend fun clearToken()
}