package com.syntax_institut.whatssyntax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.databinding.FragmentHomeBinding
import com.syntax_institut.whatssyntax.databinding.FragmentSecondBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.weiterBTN.setOnClickListener {

            //Navcontroller laden
            val navController = findNavController()

            //Navigiere zu destination
            navController.navigate(
                HomeFragmentDirections.actionHomeFragmentToSecondFragment(
                    "Hallo",
                    50
                )
            )
        } */
    }
}