package org.firezenk.cogzidelcomicworld.ui.features.character.di

import android.view.ViewGroup
import dagger.Module
import org.firezenk.cogzidelcomicworld.di.modules.ScreenModule

@Module
class CharacterModule(private val container: ViewGroup) : ScreenModule(container)