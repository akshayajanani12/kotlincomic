package org.firezenk.cogzidelcomicworld.ui.features

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.launcher.*
import org.firezenk.cogzidelcomicworld.ComicWorldApp
import org.firezenk.cogzidelcomicworld.R
import org.firezenk.cogzidelcomicworld.ui.features.home.HomeScreenRoute
import org.firezenk.kartographer.library.Kartographer
import org.firezenk.kartographer.library.dsl.route
import javax.inject.Inject

class Launcher : AppCompatActivity() {

    @Inject lateinit var router: Kartographer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launcher)

        ComicWorldApp.component add this

        application as ComicWorldApp registerLauncher this

        router.next(route {
            target = HomeScreenRoute()
            anchor = container
        })
    }
}
