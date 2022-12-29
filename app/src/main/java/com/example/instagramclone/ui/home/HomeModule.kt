package com.example.instagramclone.ui.home

import com.example.instagramclone.core.PostService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object HomeModule {

    val instance = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://d76139c7-ee9c-41c1-bae3-559cc9e27a5a.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(PostService::class.java)
        }
        factory { HomeRepository(service = get()) }
        factory<HomeContract.Presenter> { (view: HomeContract.View) ->
            HomePresenter(view, repository = get())
        }
    }
}
