package com.muhammadfiqrit.quranku.doa.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.databinding.FragmentDoaLainnyaBinding
import com.muhammadfiqrit.quranku.doa.DoaAdapter
import com.muhammadfiqrit.quranku.doa.DoaViewModel
import com.muhammadfiqrit.quranku.utils.Utilities
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class DoaLainnyaFragment : Fragment() {

    private val doaAdapter: DoaAdapter by inject()
    private val doaViewModel: DoaViewModel by viewModel()
    private var _binding: FragmentDoaLainnyaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDoaLainnyaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Utilities.populateData(
            "lainnya",
            doaViewModel,
            viewLifecycleOwner,
            binding.rvDoaLainnya,
            doaAdapter,
            requireContext()
        )
    }


}