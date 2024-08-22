package com.muhammadfiqrit.quranku.detail.ayat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.detail.AyatAdapter
import com.muhammadfiqrit.quranku.databinding.FragmentAyatBinding
import com.muhammadfiqrit.quranku.detail.DetailSuratViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class AyatFragment : Fragment() {
    private var _binding: FragmentAyatBinding? = null
    private val binding get() = _binding!!
    private val detailSuratViewModel: DetailSuratViewModel by viewModel()

    private val ayatAdapter: AyatAdapter by inject()

    companion object {
        var suratNomor: Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAyatBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        populateRecyclerView(suratNomor)


    }

    private fun populateRecyclerView(suratNomor: Int) {
        lifecycleScope.launch {
            detailSuratViewModel.setId(suratNomor)

            detailSuratViewModel.suratDetail.observe(viewLifecycleOwner) {
                val result = it
                if (result != null) {


                    when (result) {
                        is Resource.Loading -> {

                            binding.progressBarAyat.visibility = View.VISIBLE

                        }

                        is Resource.Success -> {
                            binding.progressBarAyat.visibility = View.INVISIBLE

                            result.data?.let { data ->
                                updateRecyclerView(data.listAyat)

                            }

                        }

                        is Resource.Error -> {

                            binding.progressBarAyat.visibility = View.INVISIBLE
                            Toast.makeText(
                                requireActivity(),
                                result.message,
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }

            }
        }

    }

    private fun updateRecyclerView(data: List<Ayat>?) {
        if (binding.rvAyat.layoutManager == null) {
            binding.rvAyat.layoutManager = LinearLayoutManager(requireContext())
        }
        val layoutManager = binding.rvAyat.layoutManager as LinearLayoutManager
        // Save current scroll position
        val currentPosition = layoutManager.findFirstVisibleItemPosition()
        // Update list in the adapter
        ayatAdapter.setListAyat(data)
        // Restore scroll position after data is updated
        binding.rvAyat.scrollToPosition(currentPosition)
        binding.rvAyat.isNestedScrollingEnabled = false

        if (binding.rvAyat.adapter == null) {
            binding.rvAyat.let { it ->
                it.adapter = ayatAdapter
                it.layoutManager =
                    LinearLayoutManager(requireActivity())
                it.setHasFixedSize(true)
                it.isNestedScrollingEnabled = false
            }

        }
    }
}