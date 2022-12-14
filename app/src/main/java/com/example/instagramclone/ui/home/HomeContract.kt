package com.example.instagramclone.ui.home

import com.example.instagramclone.model.Post

interface HomeContract {
    interface View {
        fun showPosts(posts: MutableList<Post>)
        fun showEmptyPosts()
        fun showLoading()
        fun hideLoading()
        fun showError(cause: String?)
    }

    interface Presenter {
        fun getPosts()
    }
}
