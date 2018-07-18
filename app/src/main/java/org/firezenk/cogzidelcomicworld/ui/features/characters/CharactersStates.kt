package org.firezenk.cogzidelcomicworld.ui.features.characters

import android.content.Context
import org.firezenk.cogzidelcomicworld.R
import org.firezenk.cogzidelcomicworld.domain.models.CharacterModel
import org.firezenk.cogzidelcomicworld.ui.features.commons.State
import javax.inject.Inject

open class CharactersStates @Inject constructor(private val context: Context) : State() {

    fun success(list: List<CharacterModel>) = Success(context, list.map {
        if (it.description.isNullOrBlank()) {
            it.copy(description = context.getString(R.string.no_description))
        } else {
            it
        }
    })

    data class Success(private val context: Context, val list: List<CharacterModel>) : CharactersStates(context)
}