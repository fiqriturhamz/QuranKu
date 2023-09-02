package com.muhammadfiqrit.quranku.ui.surat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.databinding.FragmentSuratBinding
import com.muhammadfiqrit.quranku.ui.SuratAdapter
import com.muhammadfiqrit.quranku.viewmodel.SuratViewModel
import com.muhammadfiqrit.quranku.viewmodel.ViewModelFactory


class SuratFragment : Fragment() {

    private lateinit var suratViewModel: SuratViewModel
    private var _binding: FragmentSuratBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSuratBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val suratAdapter = SuratAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity())
            suratViewModel = ViewModelProvider(this, factory)[SuratViewModel::class.java]

            suratViewModel.surat.observe(viewLifecycleOwner) { surat ->
                if (surat != null) {
                    when (surat) {
                        is Resource.Loading -> binding.suratProgressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.suratProgressBar.visibility = View.GONE
                            suratAdapter.setData(surat.data)
                        }

                        is Resource.Error -> {
                            binding.suratProgressBar.visibility = View.GONE
                            Toast.makeText(requireContext(), surat.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }

            with(binding.rvSurat) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = suratAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}