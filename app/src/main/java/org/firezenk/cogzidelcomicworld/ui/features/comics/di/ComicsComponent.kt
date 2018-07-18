package org.firezenk.cogzidelcomicworld.ui.features.comics.di

import dagger.Subcomponent
import org.firezenk.cogzidelcomicworld.di.ScreenScope
import org.firezenk.cogzidelcomicworld.ui.features.comics.ComicsScreen

@ScreenScope
@Subcomponent(modules = [ComicsModule::class])
interface ComicsComponent {
    infix fun inject(comicsScreen: ComicsScreen)
}