package com.muhammadfiqrit.quranku.detail.tafsir

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir
import com.muhammadfiqrit.quranku.detail.TafsirAdapter
import com.muhammadfiqrit.quranku.databinding.FragmentTafsirBinding
import com.muhammadfiqrit.quranku.detail.DetailSuratViewModel
import com.muhammadfiqrit.quranku.di.adapterModule
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class TafsirFragment : Fragment() {

    private val tafsirViewModel: TafsirViewModel by viewModel()
    private val detailSuratViewModel: DetailSuratViewModel by viewModel()
    private var _binding: FragmentTafsirBinding? = null
    private val tafsirAdapter: TafsirAdapter by inject()
    private val binding get() = _binding!!

    companion object {
        var suratNomor: Int = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTafsirBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        populateTafsir(suratNomor)

    }

    private fun populateTafsir(nomorSurat: Int) {
        nomorSurat.let { tafsirViewModel.setId(it) }
        tafsirViewModel.suratDetail.observe(viewLifecycleOwner) {
            val result = it
            if (result != null) {
                when (result) {
                    is Resource.Loading -> {
                        binding.progressBarTafsir.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        binding.progressBarTafsir.visibility = View.INVISIBLE
                        result.data?.let { tafsirData ->
                            updateRecyclerView(tafsirData.listTafsir)
                        }

                    }

                    is Resource.Error -> {
                        binding.progressBarTafsir.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }


    private fun updateRecyclerView(data: List<Tafsir>?) {
        if (binding.rvTafsir.layoutManager == null) {
            binding.rvTafsir.layoutManager = LinearLayoutManager(requireContext())
        }
        val layoutManager = binding.rvTafsir.layoutManager as LinearLayoutManager
        val currentPosition = layoutManager.findFirstVisibleItemPosition()
        tafsirAdapter.setListTafsir(data)
        binding.rvTafsir.scrollToPosition(currentPosition)
        binding.rvTafsir.isNestedScrollingEnabled = false
        if (binding.rvTafsir.adapter == null) {
            binding.rvTafsir.let { it ->
                it.adapter = tafsirAdapter
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.isNestedScrollingEnabled = false
            }
        }

    }

}