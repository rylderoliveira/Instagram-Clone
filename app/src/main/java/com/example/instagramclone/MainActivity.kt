package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.ui.home.HomeFragment
import com.example.instagramclone.ui.profile.ProfileFragment
import com.example.instagramclone.ui.reels.ReelsFragment
import com.example.instagramclone.ui.search.SearchFragment
import com.example.instagramclone.ui.store.StoreFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val reelsFragment = ReelsFragment()
        val storeFragment = StoreFragment()
        val profileFragment = ProfileFragment()

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_main, homeFragment)
            setReorderingAllowed(true)
        }

        binding.bottomNavigationViewMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container_view_main, homeFragment)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                }
                R.id.menu_search -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container_view_main, searchFragment)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                }
                R.id.menu_reels -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container_view_main, reelsFragment)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                }
                R.id.menu_store -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container_view_main, storeFragment)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                }
                R.id.menu_profile -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragment_container_view_main, profileFragment)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                }
            }
            true
        }
    }
}