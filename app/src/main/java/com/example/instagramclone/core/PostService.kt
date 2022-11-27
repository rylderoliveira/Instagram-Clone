package com.example.instagramclone.core

import com.example.instagramclone.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("/singlepost")
    fun getSinglePost(): Call<Post>

    @GET("/posts")
    fun getPosts(): Call<MutableList<Post>>
}
