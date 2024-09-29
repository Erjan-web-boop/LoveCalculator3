package com.example.lovecalculator.fragment.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import com.example.lovecalculator.databinding.FragmentOnBoardPagingBinding


class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPagingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0->{
                tvOnboard.text = "Очень удобный функционал"
                animationView.setAnimation(R.raw.animation1)
            }
            1->{
                tvOnboard.text = "Узнайте, подходите ли вы"
                animationView.setAnimation(R.raw.animation2)
            }
            2->{
                tvOnboard.text = "Интересная фишка"
                animationView.setAnimation(R.raw.animation3)
            }
            3->{
                tvOnboard.text = "Любовный калькулятор"
                animationView.setAnimation(R.raw.animation3)
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }

}