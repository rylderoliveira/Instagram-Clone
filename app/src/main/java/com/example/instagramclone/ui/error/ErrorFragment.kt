package com.example.instagramclone.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentErrorBinding
import com.example.instagramclone.ui.home.HomeFragment

class ErrorFragment(private val cause: String?) : Fragment() {

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
        binding.textViewErrorCause.text = cause
        binding.swipeRefreshError.setOnRefreshListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view_main, HomeFragment())
            }
        }
    }
}
