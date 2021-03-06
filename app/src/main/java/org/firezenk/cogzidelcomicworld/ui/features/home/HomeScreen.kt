package org.firezenk.cogzidelcomicworld.ui.features.home

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.support.design.widget.BottomNavigationView
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.screen_home.view.*
import org.firezenk.cogzidelcomicworld.ComicWorldApp
import org.firezenk.cogzidelcomicworld.ComicWorldApp.Companion.component
import org.firezenk.cogzidelcomicworld.R
import org.firezenk.cogzidelcomicworld.ui.features.commons.Screen
import org.firezenk.cogzidelcomicworld.ui.features.home.di.HomeModule
import org.firezenk.kartographer.annotations.RoutableView
import javax.inject.Inject

@RoutableView
class HomeScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RelativeLayout(context, attrs, defStyleAttr), Screen<HomeStates> {

    @Inject lateinit var lifecycle: Lifecycle
    @Inject lateinit var presenter: HomePresenter
    @Inject lateinit var actions: HomeActions

    private val act: Activity by lazy {
        when (context) {
            is ComicWorldApp -> context.currentLauncher()
            else -> context as Activity
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inflate(act, R.layout.screen_home, this)

        component add HomeModule(content) inject this

        lifecycle.addObserver(this)

        setupNavigation().also {
            navigation.selectedItemId = R.id.navigation_home
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() = presenter init this

    override fun render(state: HomeStates) {
        // TODO render anything right now
    }

    private fun setupNavigation() {
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    presenter reduce actions.home()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    presenter reduce actions.dashboard()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    presenter reduce actions.notifications()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}