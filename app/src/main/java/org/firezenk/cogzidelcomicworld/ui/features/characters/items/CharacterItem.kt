package org.firezenk.cogzidelcomicworld.ui.features.characters.items

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.screen_characters_item.view.*
import org.firezenk.cogzidelcomicworld.R
import org.firezenk.cogzidelcomicworld.domain.models.CharacterModel
import org.firezenk.cogzidelcomicworld.ui.extensions.BindableView
import org.firezenk.cogzidelcomicworld.ui.extensions.dsl

class CharacterItem constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr), BindableView<CharacterModel> {

    private lateinit var model: CharacterModel
    private lateinit var clickAction: (String) -> Unit

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        inflate(context, R.layout.screen_characters_item, this)

        name.text = model.name
        description.text = model.description

        avatar.dsl {
            url = model.avatarUrl
            strategy = DiskCacheStrategy.ALL
        }

        setOnClickListener { clickAction(model.id) }
    }

    override fun bind(model: CharacterModel) {
        this.model = model
    }

    fun click(block: (String) -> Unit) {
        this.clickAction = block
    }
}