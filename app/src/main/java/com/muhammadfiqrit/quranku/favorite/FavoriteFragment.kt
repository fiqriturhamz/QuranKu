package com.muhammadfiqrit.quranku.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.SuratAdapter
import com.muhammadfiqrit.quranku.databinding.FragmentFavoriteBinding
import com.muhammadfiqrit.quranku.detail.DetailSuratActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

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
            suratAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailSuratActivity::class.java)
                startActivity(intent)
            }
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