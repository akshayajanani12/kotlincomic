package org.firezenk.cogzidelcomicworld.domain.usecases

import arrow.core.Try
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import org.firezenk.cogzidelcomicworld.domain.repositories.ComicsRepository
import javax.inject.Inject

class GetComics @Inject constructor(private val comicsRepository: ComicsRepository) {

    suspend fun execute() = Try {
        async(CommonPool) {
            comicsRepository.comics()
        }.await()
    }
}