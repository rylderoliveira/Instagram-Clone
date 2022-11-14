package com.example.instagramclone.ui.componentes.postview

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import com.bumptech.glide.Glide
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ViewPostViewBinding

class PostView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    companion object {
        const val DEFAULT_PROFILE_NAME = "Usuário do Instagram"
    }

    private lateinit var binding: ViewPostViewBinding

    private val defaultIconLikeOutline = getDrawable(R.drawable.ic_like_outline)
    private val defaultIconLikeFilled = getDrawable(R.drawable.ic_like_filled)
    private val defaultIconSaveOutline = getDrawable(R.drawable.ic_save_outline)
    private val defaultIconSaveFilled = getDrawable(R.drawable.ic_save_filled)

    var imageProfile: String?
        get() = null
        set(value) {
            Glide.with(context)
                .load(Uri.parse(value))
                .into(binding.imageViewPostProfile)
        }

    var imageContent: String?
        get() = null
        set(value) {
            Glide.with(context)
                .load(Uri.parse(value))
                .into(binding.imageViewPostContent)
        }

    var postOwner: String
        get() = DEFAULT_PROFILE_NAME
        set(value) {
            binding.textViewPostOwner.text = value
        }

    var isPostLiked: Boolean
        get() = false
        set(value) {
            if (value) binding.imageButtonLike.setImageDrawable(defaultIconLikeFilled)
            else binding.imageButtonLike.setImageDrawable(defaultIconLikeOutline)
        }

    var isPostSaved: Boolean
        get() = false
        set(value) {
            if (value) binding.imageButtonLike.setImageDrawable(defaultIconSaveFilled)
            else binding.imageButtonLike.setImageDrawable(defaultIconSaveOutline)
        }

    var likesCount: Int?
        get() = null
        set(value) {
            value?.let {
                val likesText = "$value curtidas"
                binding.textViewLikesCount.text = likesText
            }
        }

    var postDescription: String?
        get() = null
        set(value) {
            value?.let {
                val description = SpannableStringBuilder()
                    .bold { append(postOwner) }
                    .append(value)
                binding.textViewDescription.text = description
            }
        }

    var commentsCount: Int?
        get() = null
        set(value) {
            value?.let {
                val commentsText = "Ver todos os $value comentários"
                binding.textViewShowAllComments.text = commentsText
            }
        }

    init {
        binding = ViewPostViewBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
    }

    private fun getDrawable(resId: Int) : Drawable? {
       return ContextCompat.getDrawable(context, resId)
    }
}
