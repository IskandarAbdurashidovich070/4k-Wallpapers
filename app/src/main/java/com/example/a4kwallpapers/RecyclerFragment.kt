package com.example.a4kwallpapers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4kwallpapers.Adapters.RvAdapter
import com.example.a4kwallpapers.databinding.FragmentRecyclerBinding
import com.example.a4kwallpapers.models.MyData1
import com.example.a4kwallpapers.models.User1

class RecyclerFragment : Fragment() {
    private lateinit var binding: FragmentRecyclerBinding
    private lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(layoutInflater)

        MyData1.loadData()

        rvAdapter = RvAdapter(MyData1.list, object : RvAdapter.Click{
            override fun rvClick(user1: User1) {
                MyData1.image = user1.image
                findNavController().navigate(R.id.setImageFragment)
            }

        })
        binding.rvView.adapter = rvAdapter
        return binding.root
    }

}