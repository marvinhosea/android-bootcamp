package pro.marvinhosea.movielist.data.models

sealed class NetworkResult<out T : Any>

data class Success<out T : Any>(val data: T) : NetworkResult<T>()

data class Failure(val error: Throwable) : NetworkResult<Nothing>()