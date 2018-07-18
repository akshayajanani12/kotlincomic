package org.firezenk.cogzidelcomicworld.domain.usecases

import arrow.core.Try
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import org.firezenk.cogzidelcomicworld.domain.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacter @Inject constructor(private val charactersRepository: CharactersRepository) {

    suspend fun execute(characterId: String) = Try {
        async(CommonPool) {
            charactersRepository.character(characterId)
        }.await()
    }
}