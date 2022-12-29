package com.example.instagramclone.ui.componentes.postview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.model.Post
import com.example.instagramclone.ui.componentes.postview.PostView

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Post) {
        val postViewHome = itemView.findViewById<PostView>(R.id.post_view_item_post_home)
        with(postViewHome) {
            postOwner = item.userNickname
            imageUrl = item.mediaUrl
            isPostLiked = false
            isPostSaved = false
            likesCount = item.usersLikes.size
            commentsCount = item.comments.size
            postDescription = item.description
            imageProfile = item.ownerPhotoUrl
        }
    }
}
