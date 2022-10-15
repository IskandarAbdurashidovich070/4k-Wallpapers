package com.example.a4kwallpapers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.a4kwallpapers.databinding.FragmentDefaultBinding
import com.example.a4kwallpapers.databinding.SetTabItemBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DefaultFragment : Fragment() {
    lateinit var binding: FragmentDefaultBinding
    lateinit var pagerAdapter: PagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDefaultBinding.inflate(layoutInflater)

        pagerAdapter = PagerAdapter(this)
        binding.pager.adapter = pagerAdapter

        binding.tab2.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.dotitem2)?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.dotitem2)?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        var list = ArrayList<Int>()
        list.add(R.drawable.home)
        list.add(R.drawable.popular)
        list.add(R.drawable.random)
        list.add(R.drawable.like)

        TabLayoutMediator(binding.tab2, binding.pager){tab, position->
            val setTabItem = SetTabItemBinding.inflate(layoutInflater)

            setTabItem.imageTab.setImageResource(list[position])

            setTabItem.dotitem2.visibility = View.GONE

            tab.customView = setTabItem.root

        }.attach()

        return binding.root
    }

}