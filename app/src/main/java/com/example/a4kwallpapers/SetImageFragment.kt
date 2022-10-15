package com.example.a4kwallpapers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4kwallpapers.databinding.FragmentSetImageBinding
import com.example.a4kwallpapers.databinding.ItemInfoBinding
import com.example.a4kwallpapers.models.MyData1
import com.google.android.material.bottomsheet.BottomSheetDialog


class SetImageFragment : Fragment() {
    private lateinit var binding: FragmentSetImageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetImageBinding.inflate(layoutInflater)


        binding.back.setBackgroundResource(MyData1.image)

        binding.back2.setOnClickListener {
         findNavController().popBackStack()
        }

        binding.info.setOnClickListener {
                val bottomSheetDialog = BottomSheetDialog(binding.root.context )
                val itemDialogBinding = ItemInfoBinding.inflate(layoutInflater)
                bottomSheetDialog.setContentView(itemDialogBinding.root)

                bottomSheetDialog.show()
            }



        return binding.root
        }


}