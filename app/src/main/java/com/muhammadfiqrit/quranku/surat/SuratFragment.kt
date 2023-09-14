package com.muhammadfiqrit.quranku.surat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.databinding.FragmentSuratBinding
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.ui.SuratAdapter
import com.muhammadfiqrit.quranku.detail.DetailSuratActivity

import org.koin.androidx.viewmodel.ext.android.viewModel


class SuratFragment : Fragment() {

    private  val suratViewModel: SuratViewModel by viewModel()
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

            suratAdapter.setOnItemClickCallback(object : SuratAdapter.OnItemClickCallback {
                override fun onSuratClick(data: Surat) {
                    val intent = Intent(requireActivity(), DetailSuratActivity::class.java)
                    intent.putExtra(DetailSuratActivity.EXTRA_SURAT_NOMOR, data.nomor)
                    startActivity(intent)
                }

            })

            suratViewModel.surat.observe(viewLifecycleOwner) { surat ->
                if (surat != null) {

                    when (surat) {
                        is com.muhammadfiqrit.quranku.core.data.Resource.Loading -> binding.suratProgressBar.visibility = View.VISIBLE
                        is com.muhammadfiqrit.quranku.core.data.Resource.Success -> {
                            binding.suratProgressBar.visibility = View.GONE
                            suratAdapter.setData(surat.data)

                        }

                        is com.muhammadfiqrit.quranku.core.data.Resource.Error -> {
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