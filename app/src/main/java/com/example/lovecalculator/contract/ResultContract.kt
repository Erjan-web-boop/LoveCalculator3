package com.example.lovecalculator.contract

import com.example.lovecalculator.Model.LoveModel


interface ResultContract {
    interface View {
        fun showData(loveModel: LoveModel)
        fun navigateToCalculation()
    }

    interface Presenter {
        fun onDataReceived(model: LoveModel)
        fun TryAgain()
    }
}