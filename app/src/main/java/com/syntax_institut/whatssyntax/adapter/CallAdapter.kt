package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.StatusFragmentDirections
import com.syntax_institut.whatssyntax.data.model.Call
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.databinding.ItemCallBinding
import com.syntax_institut.whatssyntax.databinding.ListItemBinding
class CallAdapter(
    private val context: Context,
    private val dataset: List<Call>

) : RecyclerView.Adapter<CallAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemCallBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val call = dataset[position]
        val contact: Contact
        holder.binding.tvCallName.text = call.contact.name
        holder.binding.tvCallTime.text = call.contact.number
        holder.binding.ivCallBenutzerbild.setImageResource(call.contact.image)


// Überprüft ob Anruf entgegegenommen wurde und roter oder grüner Pfeil wird angezeigt
        if (call.accepted) {
            // Wenn der Status wahr ist, ändere die Pfeilfarbe auf grün und drehe ihn entsprechend
            holder.binding.ivCallPfeil.setImageResource(R.drawable.icon_call_accepted)
        } else {
            // Wenn der Status falsch ist, ändere die Pfeilfarbe auf rot und drehe ihn entsprechend
            holder.binding.ivCallPfeil.setImageResource(R.drawable.icon_call_missed)
        }
        holder.binding.tvCallTime.text = call.time

        //holder.binding.ivCallPfeil.setImageResource()
        if (call.incoming) {
            holder.binding.ivCallPfeil.rotation = 190f
            R.drawable.icon_call_missed
            if (call.accepted) {
                holder.binding.ivCallPfeil.rotation = 190f
                R.drawable.icon_call_accepted
            }

            holder.binding.contactCard.setOnClickListener {
                val phoneNumber = call.contact.number
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phoneNumber")
                context.startActivity(intent)
            }
        }


        //Überprüft ob eingehender oder ausgehender Anrufe und Pfeil wird gedreht

        //image Pfeil drehen


        /* holder.binding.contactCard.setOnClickListener {
             holder.itemView.findNavController()
                 .navigate(StatusFragmentDirections.actionStatusFragmentToContactFragment(position))


         }*/

    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}
