package com.example.instagramclone.ui.home

import android.util.Log
import com.example.instagramclone.core.RetrofitInstance
import com.example.instagramclone.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(val view: HomeContract.View) : HomeContract.Presenter {

    override fun getSinglePost() {
        RetrofitInstance.instance.getSinglePost().enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                response.body()?.let {
                    view.showPosts(mutableListOf(it))
                    Log.i("Rylder", "Success ${it.mediaUrl}")
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.i("Rylder", "Erro")
            }
        })
    }

    override fun getPosts() {
        TODO("Not yet implemented")
    }
}