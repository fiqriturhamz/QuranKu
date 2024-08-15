package com.muhammadfiqrit.quranku.husna

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.databinding.ActivityHusnaBinding
import org.koin.android.ext.android.inject

class HusnaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHusnaBinding
    private val husnaViewModel: HusnaViewModel by inject()
    private val husnaAdapter: HusnaAdapter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHusnaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAllHusna()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }

    private fun getAllHusna() {
        husnaViewModel.getAllHusna.observe(this) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        binding.loadingHusna.visibility = View.VISIBLE
                        binding.rvListHusna.visibility = View.GONE

                    }

                    is Resource.Success -> {
                        binding.loadingHusna.visibility = View.GONE
                        binding.rvListHusna.visibility = View.VISIBLE
                        val listHusna = it.data
                        listHusna.let { husnas ->

                            binding.rvListHusna.adapter = husnaAdapter
                            husnaAdapter.setListHusna(husnas)
                            binding.rvListHusna.layoutManager = LinearLayoutManager(this)
                            binding.rvListHusna.setHasFixedSize(true)


                        }

                    }

                    is Resource.Error -> {
                        binding.loadingHusna.visibility = View.VISIBLE
                        binding.rvListHusna.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}