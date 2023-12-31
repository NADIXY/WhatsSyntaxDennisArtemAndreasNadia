package com.syntax_institut.whatssyntax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.adapter.ChatAdapter
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.FragmentChatBinding
import com.syntax_institut.whatssyntax.databinding.FragmentProfilBinding

class ChatFragment: Fragment() {

    private lateinit var binding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvChats.adapter = ChatAdapter(Datasource().getChats())

    }
}