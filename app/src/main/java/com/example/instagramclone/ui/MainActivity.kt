package com.example.instagramclone.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.ui.home.HomeFragment
import com.example.instagramclone.ui.profile.ProfileFragment
import com.example.instagramclone.ui.reels.ReelsFragment
import com.example.instagramclone.ui.search.SearchFragment
import com.example.instagramclone.ui.store.StoreFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val backStackFragments = mutableListOf<Fragment>()
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val reelsFragment = ReelsFragment()
    private val storeFragment = StoreFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_main, homeFragment)
            setReorderingAllowed(true)
            supportActionBar?.title = getString(R.string.app_name)
            backStackFragments.add(homeFragment)
        }
        binding.bottomNavigationViewMain.setOnItemSelectedListener {
            val currentItemSelected = binding.bottomNavigationViewMain.selectedItemId
            if (currentItemSelected != it.itemId) {
                when (it.itemId) {
                    R.id.menu_home -> loadFragment(homeFragment)
                    R.id.menu_search -> loadFragment(searchFragment)
                    R.id.menu_reels -> loadFragment(reelsFragment)
                    R.id.menu_store -> loadFragment(storeFragment)
                    R.id.menu_profile -> loadFragment(profileFragment)
                }
            }
            true
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backStackFragments.removeLast()
                if (backStackFragments.isEmpty()) {
                    finish()
                } else {
                    loadFragment(backStackFragments.last())
                }
            }
        })
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_main, fragment)
            setReorderingAllowed(true)
            if (backStackFragments.last() != fragment) {
                backStackFragments.add(fragment)
            }
        }
        val itemId = getMenuItemByFragment(fragment)
        itemId?.let {
            val item = binding.bottomNavigationViewMain.menu.findItem(it)
            item.isChecked = true
            setActionBarTitle(item)
        }
    }

    private fun setActionBarTitle(item: MenuItem) {
        if (item.itemId == R.id.menu_home) supportActionBar?.title = getString(R.string.app_name)
        else supportActionBar?.title = item.title
    }

    private fun getMenuItemByFragment(fragment: Fragment): Int? {
        return when (fragment) {
            homeFragment -> R.id.menu_home
            searchFragment -> R.id.menu_search
            reelsFragment -> R.id.menu_reels
            storeFragment -> R.id.menu_store
            profileFragment -> R.id.menu_profile
            else -> null
        }
    }
}
