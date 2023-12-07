package com.syntax_institut.whatssyntax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.adapter.CallAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.FragmentCallBinding
import com.syntax_institut.whatssyntax.databinding.FragmentProfilBinding

class CallFragment: Fragment() {

    private lateinit var binding: FragmentCallBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCallBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCall.adapter = CallAdapter(requireContext(),Datasource().getCalls())


    }
}