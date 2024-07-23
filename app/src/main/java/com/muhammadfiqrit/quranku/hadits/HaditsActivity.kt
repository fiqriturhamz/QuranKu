package com.muhammadfiqrit.quranku.hadits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.databinding.ActivityHaditsBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HaditsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHaditsBinding
    private val haditsAdapter: HaditsAdapter by inject()
    private val haditsViewModel: HaditsViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaditsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateData()
    }

    private fun populateData() {
        haditsViewModel.getAllHadits().observe(this) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        haditsAdapter.setData(it.data)
                        binding.rvHadits.adapter = haditsAdapter
                        binding.rvHadits.layoutManager = LinearLayoutManager(this)
                        binding.rvHadits.setHasFixedSize(true)
                    }

                    is Resource.Error -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}