package com.syntax_institut.whatssyntax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.data.model.Profile
import com.syntax_institut.whatssyntax.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val new = mainActivity.datasourceExtra.getContacts().toMutableList()

        val datasource = Datasource()

        binding.btnSettingsSave.setOnClickListener {
            val name = binding.txSettingsName.text.toString()
            val nummer = binding.txTettingsTelefonnummer.text.toString()

            datasource.setProfile(Profile(name, nummer, R.drawable.pp_01))

            val profile = datasource.getProfile()
            binding.tvNewName.text = profile.name
            binding.tvNewNummer.text = profile.number
        }
    }



}