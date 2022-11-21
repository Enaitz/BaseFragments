package com.enaitzdam.provaviewmodel

import androidx.lifecycle.ViewModel

class IniciViewModel : ViewModel(){

    //private var wordsList: MutableList<String> = mutableListOf()
    private var _currentSuma=0
    val currentSuma: Int
        get() = _currentSuma

    private var _currentNom=""
    val currentNom: String
        get() = _currentNom



    fun sumarClicks(){
        ++_currentSuma
        calculaNom()
    }

    private fun calculaNom() {
        when (_currentSuma) {
            10 -> _currentNom +=" 10"
            20 -> _currentNom +=" 20"
            30 -> _currentNom +=" 30"
        }
    }


    fun reinitializeData() {
        _currentSuma = 0
        _currentNom = ""
    }
}