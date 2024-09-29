package com.example.lovecalculator.fragment.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lovecalculator.Model.OnBoardViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.adapter.OnBoardAdapter
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private val onBoardViewModel: OnBoardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        binding.tvWork.setOnClickListener {
            onBoardViewModel.setOnboardingCompleted()
            findNavController().navigate(R.id.action_onBoardFragment_to_loveFragment)
        }
    }

    private fun initialize() {
        binding.vpViewpager2.adapter = OnBoardAdapter(this@OnBoardFragment)
    }

    private fun setupListener() = with(binding.vpViewpager2) {
        registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 3) {
                    binding.tvWork.visibility = View.VISIBLE
                } else {
                    binding.tvWork.visibility = View.INVISIBLE
                }
            }
        })

        registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 4) {
                    binding.tvSkip.visibility = View.INVISIBLE
                } else {
                    binding.tvSkip.visibility = View.VISIBLE
                }
            }
        })
        binding.tvSkip.setOnClickListener {
            if (currentItem < 3)
                setCurrentItem(currentItem + 3, true)
        }
    }


}