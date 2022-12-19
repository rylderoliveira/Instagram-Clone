package com.example.instagramclone.ui.home

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter(
    val view: HomeContract.View,
    val repository: HomeRepository
) : HomeContract.Presenter {

    override fun getSinglePost() {
        repository.getSinglePost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .doOnSuccess { view.hideLoading() }
            .subscribe()
    }

    override fun getPosts() {
        repository.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoading() }
            .doOnSuccess {
                view.hideLoading()
                view.showPosts(it)
            }
            .subscribe()
    }
}
