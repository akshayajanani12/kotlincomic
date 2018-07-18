package org.firezenk.cogzidelcomicworld.ui.features.character

import org.firezenk.cogzidelcomicworld.domain.models.CharacterModel
import org.firezenk.cogzidelcomicworld.ui.features.commons.State
import javax.inject.Inject

open class CharacterStates @Inject constructor() : State() {

    fun success(model: CharacterModel) = Loaded(model.name)

    fun error() = Error()

    data class Loaded(val name: String): CharacterStates()
    class Error: CharacterStates()
}