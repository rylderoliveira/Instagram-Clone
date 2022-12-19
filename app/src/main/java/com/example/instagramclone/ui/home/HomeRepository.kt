package com.example.instagramclone.ui.home

import com.example.instagramclone.core.PostService

class HomeRepository(
    private val service: PostService
) {

    fun getSinglePost() = service.getSinglePost()

    fun getPosts() = service.getPosts()
}
