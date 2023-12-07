package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.databinding.ItemMessageBinding
import com.syntax_institut.whatssyntax.databinding.ItemMessageUserBinding

class MessageAdapter(
    val dataset: List<Message>

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val messageChat = 1
    val userChat = 2

    inner class KontaktViewHolder(val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class IchViewHolder(val binding: ItemMessageUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        val item = dataset[position]
        return if (item.incoming) {
            messageChat
        } else {
            userChat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == messageChat) {
            val binding =
                ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            KontaktViewHolder(binding)
        } else {
            val binding =
                ItemMessageUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            IchViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataset[position]

        if (holder is KontaktViewHolder) {
            holder.binding.tvMessageChatText.text = item.text
        } else if (holder is IchViewHolder) {
            holder.binding.tvUserChatText.text = item.text
        }
    }
}