package com.example.lovecalculator.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.contract.LoveContract
import com.example.lovecalculator.Model.LoveModel
import com.example.lovecalculator.presenter.LovePresenter
import com.example.lovecalculator.R
import com.example.lovecalculator.service.RetrofitService
import com.example.lovecalculator.databinding.FragmentLoveBinding


class LoveFragment : Fragment(), LoveContract.View {

    private lateinit var binding: FragmentLoveBinding
    private lateinit var presenter: LoveContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = LovePresenter(this, RetrofitService)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            val firstName = et1.text.toString()
            val secondName = et2.text.toString()
            presenter.calculateLovePercentage(firstName, secondName)
        }
    }

    override fun showResult(loveModel: LoveModel) {
        setFragmentResult(
            "KEY_ARG", bundleOf("data" to loveModel)
        )
    }

    override fun navigateToResult() {
        findNavController().navigate(R.id.resultFragment)
    }

    override fun showError(message: String) {
        Log.e("Error", message)
    }
}
