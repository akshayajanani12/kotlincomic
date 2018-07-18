package org.firezenk.cogzidelcomicworld.ui.features.characters.di

import dagger.Subcomponent
import org.firezenk.cogzidelcomicworld.di.ScreenScope
import org.firezenk.cogzidelcomicworld.ui.features.characters.CharactersScreen

@ScreenScope
@Subcomponent(modules = [CharactersModule::class])
interface CharactersComponent {
    infix fun inject(charactersScreen: CharactersScreen)
}