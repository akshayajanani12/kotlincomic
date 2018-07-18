package org.firezenk.cogzidelcomicworld.ui.features.comics.di

import android.view.ViewGroup
import dagger.Module
import org.firezenk.cogzidelcomicworld.di.modules.ScreenModule

@Module
class ComicsModule(private val container: ViewGroup) : ScreenModule(container)