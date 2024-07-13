package com.muhammadfiqrit.quranku.lokasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.LokasiAdapter
import com.muhammadfiqrit.quranku.databinding.FragmentLocationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LokasiFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!
    private val lokasiViewModel: LokasiViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {


            val lokasiAdapter = LokasiAdapter(requireContext(), lokasiViewModel)
            lokasiViewModel.lokasi.observe(viewLifecycleOwner) { lokasi ->
                if (lokasi != null) {
                    when (lokasi) {
                        is Resource.Loading -> binding.lokasiProgressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.lokasiProgressBar.visibility = View.GONE
                            lokasiAdapter.setData(lokasi.data)

                        }

                        is Resource.Error -> {
                            binding.lokasiProgressBar.visibility = View.GONE
                            Toast.makeText(requireContext(), "Tidak ada lokasi", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
            with(binding.rvSemuaLokasi) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = lokasiAdapter
            }
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}