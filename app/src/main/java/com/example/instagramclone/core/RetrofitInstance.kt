package com.example.instagramclone.core

import com.example.instagramclone.ui.home.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://d76139c7-ee9c-41c1-bae3-559cc9e27a5a.mock.pstmn.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance: PostService = retrofit.create(PostService::class.java)
}