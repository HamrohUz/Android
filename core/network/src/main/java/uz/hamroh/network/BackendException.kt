package uz.hamroh.network

import java.io.IOException

class BackendException(
    val code: Int = 0,
    message: String = "",
) : IOException(message)