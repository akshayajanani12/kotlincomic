package org.firezenk.cogzidelcomicworld.ui.features.characters

import org.firezenk.cogzidelcomicworld.domain.usecases.GetCharacters
import org.firezenk.cogzidelcomicworld.ui.features.commons.Action
import javax.inject.Inject

class CharactersActions @Inject constructor(private val getCharacters: GetCharacters) : Action() {

    fun loadCharacters() = LoadCharacters(getCharacters)

    fun openCharacter(id: String) = OpenCharacter(id)

    sealed class CharactersAction : Action() {

        class LoadCharacters(val getCharacters: GetCharacters) : CharactersAction()

        class OpenCharacter(val id: String) : CharactersAction()
    }
}

typealias Actions = CharactersActions.CharactersAction
typealias LoadCharacters = CharactersActions.CharactersAction.LoadCharacters
typealias OpenCharacter = CharactersActions.CharactersAction.OpenCharacter