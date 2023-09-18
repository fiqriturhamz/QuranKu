package com.muhammadfiqrit.quranku.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateData("2023/09/17",1301)
    }

    fun populateData(tanggal: String, idKota: Int) {
        homeViewModel.setIdKota(idKota)
        homeViewModel.setTanggal(tanggal)
        homeViewModel.jadwalSholatHarian.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
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