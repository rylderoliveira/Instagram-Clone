package com.example.instagramclone.ui.home

import com.example.instagramclone.core.RetrofitInstance
import com.example.instagramclone.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(val view: HomeContract.View) : HomeContract.Presenter {

    override fun getSinglePost() {
        RetrofitInstance.instance.getSinglePost().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                response.body()?.let {
                    view.showPosts(mutableListOf(it))
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                // TODO: Error message
            }
        })
    }

    override fun getPosts() {
        RetrofitInstance.instance.getPosts().enqueue(object : Callback<MutableList<Post>> {
            override fun onResponse(
                call: Call<MutableList<Post>>,
                response: Response<MutableList<Post>>,
            ) {
                response.body()?.let {
                    view.showPosts(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                // TODO: Error message
            }
        })
    }
}
