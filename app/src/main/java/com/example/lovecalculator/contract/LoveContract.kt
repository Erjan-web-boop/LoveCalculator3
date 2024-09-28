package com.example.lovecalculator.contract

import com.example.lovecalculator.Model.LoveModel


interface LoveContract {
    interface View {
        fun showResult(loveModel: LoveModel)
        fun showError(message: String)
        fun navigateToResult()
    }

    interface Presenter {
        fun calculateLovePercentage(firstName: String, secondName: String)
    }
}