package com.example.instagramclone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.model.Post
import com.example.instagramclone.ui.componentes.postview.adapter.PostAdapter
import com.example.instagramclone.ui.error.ErrorFragment
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.parameter.parametersOf

class HomeFragment : Fragment(), HomeContract.View {

    private val modules = HomeModule.instance
    private val presenter: HomeContract.Presenter by inject { parametersOf(this) }
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
        loadKoinModules(modules)
        presenter.getPosts()
        initListeners()
    }

    private fun initListeners() {
        binding.root.setOnRefreshListener {
            presenter.getPosts()
        }
    }

    override fun showPosts(posts: MutableList<Post>) {
        adapter.itemsPost = posts
        binding.recyclerViewHomePosts.adapter = adapter
    }

    override fun showEmptyPosts() {
        showErrorFragment()
    }

    override fun showLoading() {
        binding.shimmerHome.visibility = View.VISIBLE
        binding.shimmerHome.startShimmer()
    }

    override fun hideLoading() {
        hideRefreshIcon()
        binding.shimmerHome.stopShimmer()
        binding.shimmerHome.visibility = View.GONE
    }

    override fun showError(cause: String?) {
        hideRefreshIcon()
        showErrorFragment(cause)
    }

    private fun showErrorFragment(cause: String? = null) {
        parentFragmentManager.commit {
            replace(R.id.fragment_container_view_main, ErrorFragment(cause, this@HomeFragment))
        }
    }

    private fun hideRefreshIcon() {
        binding.root.isRefreshing = false
    }
}
