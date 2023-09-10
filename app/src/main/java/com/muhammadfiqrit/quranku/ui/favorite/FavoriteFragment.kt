package com.muhammadfiqrit.quranku.ui.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.databinding.FragmentFavoriteBinding
import com.muhammadfiqrit.quranku.databinding.FragmentSuratBinding
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.ui.detail.DetailSuratActivity
import com.muhammadfiqrit.quranku.ui.surat.SuratAdapter
import kotlinx.coroutines.flow.observeOn
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            val suratAdapter = SuratAdapter()
            suratAdapter.setOnItemClickCallback(object : SuratAdapter.OnItemClickCallback {
                override fun onSuratClick(data: Surat) {
                    val intent = Intent(requireActivity(), DetailSuratActivity::class.java)
                    intent.putExtra(DetailSuratActivity.EXTRA_SURAT_NOMOR, data.nomor)
                    startActivity(intent)
                }

            })
            favoriteViewModel.favoriteSurat.observe(viewLifecycleOwner) { dataSurat ->
                suratAdapter.setData(dataSurat)
            }

            with(binding.rvFavoriteSurat) {
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