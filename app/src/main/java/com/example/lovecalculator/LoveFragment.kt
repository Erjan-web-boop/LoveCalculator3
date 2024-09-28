package com.example.lovecalculator

import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentLoveBinding



class LoveFragment : Fragment() {

    private lateinit var binding: FragmentLoveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            val firstName = et1.text.toString()
            val secondName = et2.text.toString()
            calculateLovePercentage(firstName, secondName)
        }
    }

    private fun calculateLovePercentage(firstName: String, secondName: String) {
        RetrofitService.api.getPercentage(
            firstName = firstName,
            secondName = secondName,
            key = "5509405cefmsh9bed6b59752cd2dp122f66jsn5c584c4df139",
            host = "love-calculator.p.rapidapi.com"
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful && response.body() != null) {
                    val result = response.body()!!
                    showResult(result)
                    navigateToResult()
                } else {
                }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
            }
        })
    }

    private fun showResult(loveModel: LoveModel) {
        setFragmentResult("KEY_ARG", bundleOf("data" to loveModel))
    }

    private fun navigateToResult() {
        findNavController().navigate(R.id.resultFragment)
    }

}
