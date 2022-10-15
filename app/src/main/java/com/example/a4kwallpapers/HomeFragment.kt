package com.example.a4kwallpapers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.a4kwallpapers.Adapters.MyFragmentPagerAdapter
import com.example.a4kwallpapers.databinding.FragmentHomeBinding
import com.example.a4kwallpapers.databinding.ItemTabBinding
import com.example.a4kwallpapers.databinding.SetTabItemBinding
import com.example.a4kwallpapers.models.User1
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var fragmentPagerAdapter: MyFragmentPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        fragmentPagerAdapter = MyFragmentPagerAdapter(this)
        binding.pager.adapter = fragmentPagerAdapter
        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.dotitem)?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.dotitem)?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        var list = ArrayList<String>()

        list.add("All")
        list.add("New")
        list.add("Nature")

        TabLayoutMediator(binding.tab, binding.pager){tab, position->
            val itemTabBinding = ItemTabBinding.inflate(layoutInflater)

            itemTabBinding.tvItem.text = list[position]

            itemTabBinding.dotitem.visibility = View.GONE

            tab.customView = itemTabBinding.root
        }.attach()

        return binding.root
    }

}