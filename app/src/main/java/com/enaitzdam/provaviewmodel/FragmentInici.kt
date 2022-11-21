package com.enaitzdam.provaviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.enaitzdam.provaviewmodel.databinding.FragmentIniciBinding


class FragmentInici : Fragment() {


    // Binding object instance with access to the views in the game_fragment.xml layout
    private lateinit var binding: FragmentIniciBinding
    private val viewModel: IniciViewModel by viewModels()

    // Per poder treballar amb variables privades dins de la classe ViewModel amb protecció que no es pugui entrar des d'altre lloc, es fa un getter a mà a una VAL.
    // Declare private mutable variable that can only be modified within the class it is declared.
    private var _currentClickCount = 0

    // Declare another public immutable field and override its getter method.
// Return the private property's value in the getter method. When count is accessed, the get() function is called and the value of _count is returned.
    val currentClickCount: Int
        get() = _currentClickCount

    //Nom de l'usuari
    private var _nom = "Inicial"

    val nom: String
        get() = _nom


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_inici, container, false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup a click listener for the Submit and Skip buttons.
        binding.buttonSumar.setOnClickListener { onSumar() }
        binding.buttonReset.setOnClickListener{onReset()}

        binding.textViewTotal.text = currentClickCount.toString()
        //binding.score.text = getString(R.string.score, 0)

    }

    private fun onReset() {
        viewModel.reinitializeData()
    }

    private fun onSumar() {
        viewModel.sumarClicks()
        updateScreen()
    }

    private fun updateScreen(){
        binding.textViewTotal.text = viewModel.currentSuma.toString()
        binding.editTextNom.setText(viewModel.currentNom)
    }


}