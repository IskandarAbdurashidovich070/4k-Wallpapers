package com.example.a4kwallpapers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentManager: Fragment) : FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        if (position!=2) return HomeFragment()
        else return ShuffleFragment()
    }

}