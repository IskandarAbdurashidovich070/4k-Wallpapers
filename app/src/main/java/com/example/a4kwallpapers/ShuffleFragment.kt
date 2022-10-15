package com.example.a4kwallpapers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a4kwallpapers.Adapters.RvAdapter
import com.example.a4kwallpapers.databinding.FragmentShuffleBinding
import com.example.a4kwallpapers.models.MyData1
import com.example.a4kwallpapers.models.User1

class ShuffleFragment : Fragment() {
    lateinit var binding: FragmentShuffleBinding
    lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShuffleBinding.inflate(layoutInflater)

        MyData1.list.clear()

        MyData1.loadData()

        MyData1.list.shuffle()

        rvAdapter = RvAdapter(MyData1.list, object : RvAdapter.Click{
            override fun rvClick(user1: User1) {
            }
        })

        binding.rvShuffle.adapter = rvAdapter

        return binding.root
    }
}