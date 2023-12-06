package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.StatusFragment
import com.syntax_institut.whatssyntax.StatusFragmentDirections
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.databinding.ListItemBinding

class StatusAdapter (

    private val dataset: List<Contact>

) : RecyclerView.Adapter<StatusAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.binding.tvItemName.text = item.name
        holder.binding.contactCard.setOnClickListener {
           holder.itemView.findNavController().navigate(StatusFragmentDirections.actionStatusFragment2ToContactFragment(position))
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}



