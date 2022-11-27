package com.example.instagramclone.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.model.Post

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var presenter: HomeContract.Presenter
    private lateinit var binding: FragmentHomeBinding
    private val adapter: PostAdapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenter(this)
        presenter.getPosts()
    }

    override fun showPosts(posts: MutableList<Post>) {
        adapter.itemsPost = posts
        binding.recyclerViewHomePosts.adapter = adapter
    }

    override fun showEmptyPosts() {
        TODO("Not yet implemented")
    }
}
