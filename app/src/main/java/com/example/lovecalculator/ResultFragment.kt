package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentLoveBinding
import com.example.lovecalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Data()
        initListener()
    }

    private fun Data() = with(binding) {
        setFragmentResultListener("KEY_ARG") { _, bundle ->
            val result = bundle.getSerializable("data") as? LoveModel
            if (result != null) {
                showData(result)
            } else {
                Log.e("ResultFragment", "data is null")
            }
        }
    }

    private fun initListener() {
        binding.btnTryAgain.setOnClickListener {
            navigateToCalculation()
        }
    }

    private fun showData(loveModel: LoveModel) = with(binding) {
        tvName1.text = loveModel.firstName
        tvName2.text = loveModel.secondName
        tvPercent.text = loveModel.percentage
        tvResult.text = loveModel.result
    }

    private fun navigateToCalculation() {
        findNavController().navigate(R.id.loveFragment)
    }

}