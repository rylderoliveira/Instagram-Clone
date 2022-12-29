package com.example.instagramclone.ui.home

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter(
    val view: HomeContract.View,
    val repository: HomeRepository
) : HomeContract.Presenter {

    private val disposable = CompositeDisposable()

    override fun getPosts() {
        disposable.add(
            repository.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showLoading() }
                .subscribe(
                    /* onSuccess = */
                    {
                        view.hideLoading()
                        if (it.isNotEmpty()) view.showPosts(it) else view.showEmptyPosts()
                    },
                    /* onError = */
                    {
                        view.hideLoading()
                        view.showError(it.message)
                    },
                )
        )
    }
}
