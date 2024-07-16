package com.muhammadfiqrit.quranku.lokasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.databinding.FragmentLocationBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class LokasiFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!
    private val lokasiViewModel: LokasiViewModel by viewModel()
    private val lokasiAdapter: LokasiAdapter by inject()
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