package com.example.lovecalculator.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lovecalculator.fragment.OnBoard.OnBoardFragment
import com.example.lovecalculator.fragment.OnBoard.OnBoardPagingFragment
import com.example.lovecalculator.fragment.OnBoard.OnBoardPagingFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ONBOARD_POSITION, position)
            }
    }
}
