package com.example.lovecalculator.presenter


import com.example.lovecalculator.contract.LoveContract
import com.example.lovecalculator.Model.LoveModel
import com.example.lovecalculator.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LovePresenter(
    private val view: LoveContract.View,
    private val apiService: RetrofitService
) : LoveContract.Presenter {

    override fun calculateLovePercentage(firstName: String, secondName: String) {

        RetrofitService.api.getPercentage(
            firstName = firstName,
            secondName = secondName,
            key = "5509405cefmsh9bed6b59752cd2dp122f66jsn5c584c4df139",
            host = "love-calculator.p.rapidapi.com"
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful && response.body() != null) {
                    val result = response.body()
                    result?.let { view.showResult(it) }
                    view.navigateToResult()
                } else {
                    view.showError("Error fetching data")
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.showError("Request failed: ${t.message}")
            }
        })
    }
}