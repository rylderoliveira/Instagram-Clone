package com.example.instagramclone.ui.home

import com.example.instagramclone.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("/singlepost")
    fun getSinglePost(): Call<Post>
}