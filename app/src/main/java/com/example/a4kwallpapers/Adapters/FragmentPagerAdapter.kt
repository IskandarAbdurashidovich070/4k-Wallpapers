package com.example.a4kwallpapers.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a4kwallpapers.RecyclerFragment
import com.example.a4kwallpapers.databinding.FragmentRecyclerBinding
import com.example.a4kwallpapers.models.User

 class MyFragmentPagerAdapter( fa:Fragment): FragmentStateAdapter(fa) {
     override fun getItemCount(): Int = 3

     override fun createFragment(position: Int): Fragment {
         return RecyclerFragment()
     }


 }


