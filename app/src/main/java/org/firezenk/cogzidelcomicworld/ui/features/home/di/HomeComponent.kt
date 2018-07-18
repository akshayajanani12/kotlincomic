package org.firezenk.cogzidelcomicworld.ui.features.home.di

import dagger.Subcomponent
import org.firezenk.cogzidelcomicworld.di.ScreenScope
import org.firezenk.cogzidelcomicworld.ui.features.home.HomeScreen

@ScreenScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {
    infix fun inject(homeScreen: HomeScreen)
}