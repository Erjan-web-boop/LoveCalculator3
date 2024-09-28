package com.example.lovecalculator.presenter

import com.example.lovecalculator.Model.LoveModel
import com.example.lovecalculator.contract.ResultContract


class ResultPresenter(private val view: ResultContract.View) : ResultContract.Presenter {

    override fun onDataReceived(model: LoveModel) {
        view.showData(model)
    }

    override fun TryAgain() {
        view.navigateToCalculation()
    }
}