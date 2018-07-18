package org.firezenk.cogzidelcomicworld.ui.features.character.di

import dagger.Subcomponent
import org.firezenk.cogzidelcomicworld.di.ScreenScope
import org.firezenk.cogzidelcomicworld.ui.features.character.CharacterScreen

@ScreenScope
@Subcomponent(modules = [CharacterModule::class])
interface CharacterComponent {
    infix fun inject(characterScreen: CharacterScreen)
}