package com.example.instagramclone.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentErrorBinding

class ErrorFragment(private val cause: String?, private val fragment: Fragment) : Fragment() {

    private lateinit var binding: FragmentErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentErrorBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        if ( cause == null ) showOnEmptyList() else showOnError()
    }

    private fun showOnEmptyList() {
        binding.textViewErrorTitle.text = getString(R.string.empty_list_title)
        binding.textViewErrorCause.text = cause
        binding.imageViewError.setImageResource(R.drawable.empty_list_image)
    }

    private fun showOnError() {
        binding.textViewErrorTitle.text = getString(R.string.error_title)
        binding.textViewErrorCause.text = cause
        binding.imageViewError.setImageResource(R.drawable.error_image)
    }

    private fun initListeners() {
        binding.swipeRefreshError.setOnRefreshListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view_main, fragment)
            }
        }
    }
}
