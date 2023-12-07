package com.syntax_institut.whatssyntax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.adapter.MessageAdapter
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.databinding.FragmentMessageBinding
import com.syntax_institut.whatssyntax.databinding.FragmentProfilBinding

class MessageFragment: Fragment() {

    private lateinit var binding: FragmentMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Greift auf die MainActivity zu um die werte dort zu speichern.
        val mainActivity = activity as MainActivity
        val chats = mainActivity.datasourceExtra.getChats()

        var position = 0
        arguments?.let {
            position = it.getInt("position")
        }

        binding.rvChat.adapter = MessageAdapter(chats[position].messages)

        binding.buttonSend.setOnClickListener {
            val contact = binding.textNachricht.text.toString()
            val text = Message(contact, false)
            chats[position].messages.add(text)
            binding.rvChat.adapter = MessageAdapter(chats[position].messages)

            binding.textNachricht.text?.clear()

        }
    }
}