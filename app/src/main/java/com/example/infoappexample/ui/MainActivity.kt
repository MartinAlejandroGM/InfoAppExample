package com.example.infoappexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.infoappexample.R
import com.example.infoappexample.adapter.RandomUserAdapter
import com.example.infoappexample.databinding.ActivityMainBinding
import com.example.infoappexample.viewmodel.RandomUserViewModel
import com.example.infoappexample.extension.observe
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var randomUserViewModel: RandomUserViewModel
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var randomUserAdapter: RandomUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        randomUserViewModel = RandomUserViewModel(application)

        observeFetchInfo()
        randomUserViewModel.fetchInfo()
    }

    private fun attachPager(){
        TabLayoutMediator(activityMainBinding.tabLayout, activityMainBinding.pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Basic"
                }
                1 -> {
                    tab.text = "Contact"
                }
                2 -> {
                    tab.text = "Address"
                }
                3 -> {
                    tab.text = "Log/Cred"
                }
                4 -> {
                    tab.text = "Account"
                }
            }
        }.attach()
    }

    private fun initViewPager() {
        activityMainBinding.pager.apply {
            randomUserAdapter = RandomUserAdapter()
            adapter = randomUserAdapter
        }
    }

    private fun setImage(url: String){
        Picasso.with(this).load(url).error(R.drawable.ic_launcher_background).resize(400, 400).into(activityMainBinding.userPic)
    }

    private fun observeFetchInfo(){
        randomUserViewModel.fetchInfo.observe(this, {
            setImage(it.results.first().picture.large)
            initViewPager()
            randomUserAdapter.submitRandomUserInfo(it)
            attachPager()
        }, {
            it.printStackTrace()
        })
    }
}