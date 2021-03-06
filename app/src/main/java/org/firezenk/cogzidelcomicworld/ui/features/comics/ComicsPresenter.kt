package org.firezenk.cogzidelcomicworld.ui.features.comics

import arrow.core.getOrDefault
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.firezenk.cogzidelcomicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class ComicsPresenter @Inject constructor(router: Kartographer, private val states: ComicsStates)
    : Presenter<Actions, ComicsStates>(router) {

    override fun reduce(action: Actions) {
        when(action) {
            is LoadComics -> launch(UI) {
                action.getComics.execute().run {
                    render(states.success(getOrDefault { emptyList() }))
                }
            }
        }
    }
}