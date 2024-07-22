package com.muhammadfiqrit.quranku.doa.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.databinding.FragmentDoaQuranBinding
import com.muhammadfiqrit.quranku.doa.DoaAdapter
import com.muhammadfiqrit.quranku.doa.DoaViewModel
import com.muhammadfiqrit.quranku.utils.Utilities
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class DoaQuranFragment : Fragment() {

    private var _binding: FragmentDoaQuranBinding? = null
    private val binding get() = _binding!!
    private val doaViewModel: DoaViewModel by viewModel()
    private val doaAdapter: DoaAdapter by inject()
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
        Utilities.populateData(
            "quran",
            doaViewModel,
            viewLifecycleOwner,
            binding.rvDoaQuran,
            doaAdapter,
            requireContext(),

        )

    }

    /*    fun populateData(keyword: String) {
            doaViewModel.setKeyword(keyword)
            doaViewModel.doa.observe(viewLifecycleOwner) {
                if (it != null) {
                    when (it) {
                        is Resource.Loading -> {

                        }

                        is Resource.Success -> {
                            binding.rvDoaQuran.adapter = rvDoaQuran
                            rvDoaQuran.setDataDoa(it.data)
                            Log.e("doaQuran", it.data.toString())
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
        }*/

}