package com.muhammadfiqrit.quranku.doa.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.databinding.FragmentDoaQuranBinding
import com.muhammadfiqrit.quranku.databinding.FragmentHomeBinding
import com.muhammadfiqrit.quranku.doa.DoaAdapter
import com.muhammadfiqrit.quranku.doa.DoaViewModel
import org.koin.android.ext.android.inject


class DoaQuranFragment : Fragment() {

    private var _binding: FragmentDoaQuranBinding? = null
    private val binding get() = _binding!!
    private val doaViewModel: DoaViewModel by inject()
    private val rvDoaQuran: DoaAdapter by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDoaQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateData("quran")

    }

    fun populateData(keyword: String) {
        doaViewModel.setKeyword(keyword)
        doaViewModel.doa.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        rvDoaQuran.setDataDoa(it.data)
                        binding.rvDoaQuran.adapter = rvDoaQuran
                        binding.rvDoaQuran.layoutManager = LinearLayoutManager(requireContext())
                        binding.rvDoaQuran.setHasFixedSize(true)
                    }

                    is Resource.Error -> {
                        Log.e("error", "${it.message}")
                        Toast.makeText(requireActivity(), "${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

}