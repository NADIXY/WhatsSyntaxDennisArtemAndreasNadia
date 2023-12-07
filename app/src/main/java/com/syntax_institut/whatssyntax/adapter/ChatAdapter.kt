package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.ChatFragmentDirections
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.databinding.ItemChatBinding

class ChatAdapter(
    val dataset: List<Chat>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.ivCallBenutzerbild.setImageResource(item.contact.image)
        holder.binding.tvCallName.text = item.contact.name
        holder.binding.tvCallTime.text = item.messages.last().text

        holder.binding.contactCard.setOnClickListener {
            holder.itemView.findNavController().navigate(
                ChatFragmentDirections.actionChatFragmentToMessageFragment(position)
            )
        }
    }
}