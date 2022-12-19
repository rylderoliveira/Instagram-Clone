package com.example.instagramclone.core

import com.example.instagramclone.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostService {
    @GET("/singlepost")
    fun getSinglePost(): Single<Post>

    @GET("/posts")
    fun getPosts(): Single<MutableList<Post>>
}
