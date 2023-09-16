package com.muhammadfiqrit.quranku.detail.tafsir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.ui.TafsirAdapter
import com.muhammadfiqrit.quranku.databinding.FragmentTafsirBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class TafsirFragment : Fragment() {

    private val tafsirViewModel: TafsirViewModel by viewModel()
    private var _binding: FragmentTafsirBinding? = null
    private val binding get() = _binding!!

    companion object {
        var suratNomor : Int = 1
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

    fun populateTafsir(nomorSurat: Int) {
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
                            binding.apply {
                                rvTafsir.adapter = TafsirAdapter(tafsirData)
                                rvTafsir.layoutManager = LinearLayoutManager(requireActivity())
                                rvTafsir.setHasFixedSize(true)
                            }
                        }

                    }

                    is Resource.Error -> {
                        binding.progressBarTafsir.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }


}