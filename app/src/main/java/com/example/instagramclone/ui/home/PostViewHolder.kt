package com.example.instagramclone.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.model.Post
import com.example.instagramclone.ui.componentes.postview.PostView

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Post) {
        val postViewHome = itemView.findViewById<PostView>(R.id.post_view_item_post_home)
    }
}
