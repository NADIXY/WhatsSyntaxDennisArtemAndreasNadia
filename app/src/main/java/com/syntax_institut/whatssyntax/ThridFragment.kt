package com.syntax_institut.whatssyntax
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.databinding.FragmentSecondBinding
import com.syntax_institut.whatssyntax.databinding.FragmentThridBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThridBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thrid, container, false)
    }
}