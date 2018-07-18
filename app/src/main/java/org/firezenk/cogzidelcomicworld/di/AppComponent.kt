package org.firezenk.cogzidelcomicworld.di

import dagger.Component
import org.firezenk.cogzidelcomicworld.ComicWorldApp
import org.firezenk.cogzidelcomicworld.di.modules.AppModule
import org.firezenk.cogzidelcomicworld.di.modules.NetworkModule
import org.firezenk.cogzidelcomicworld.ui.features.Launcher
import org.firezenk.cogzidelcomicworld.ui.features.character.di.CharacterComponent
import org.firezenk.cogzidelcomicworld.ui.features.character.di.CharacterModule
import org.firezenk.cogzidelcomicworld.ui.features.characters.di.CharactersComponent
import org.firezenk.cogzidelcomicworld.ui.features.characters.di.CharactersModule
import org.firezenk.cogzidelcomicworld.ui.features.comics.di.ComicsComponent
import org.firezenk.cogzidelcomicworld.ui.features.comics.di.ComicsModule
import org.firezenk.cogzidelcomicworld.ui.features.home.di.HomeComponent
import org.firezenk.cogzidelcomicworld.ui.features.home.di.HomeModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    infix fun inject(app: ComicWorldApp)

    infix fun add(launcher: Launcher)
    infix fun add(homeModule: HomeModule): HomeComponent
    infix fun add(charactersModule: CharactersModule): CharactersComponent
    infix fun add(comicsModule: ComicsModule): ComicsComponent
    infix fun add(characterModule: CharacterModule): CharacterComponent
}