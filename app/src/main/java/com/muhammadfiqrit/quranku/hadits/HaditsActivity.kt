package com.muhammadfiqrit.quranku.hadits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.hadits.Hadits
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.hadits_menu, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as androidx.appcompat.widget.SearchView



        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return filterData(query as String)

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return filterData(newText as String)

            }

        })
        return true
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

    private fun filterData(query: String): Boolean {
        val filteredData = haditsAdapter.getData().filter {
            it.judulHadits.contains(
                query,
                ignoreCase = true
            ) || it.teksIndo.contains(query, ignoreCase = true)
        }

        return if (filteredData.isNotEmpty()) {
            haditsAdapter.setData(filteredData)
            haditsAdapter.notifyDataSetChanged()
            true

        } else {
            haditsAdapter.setData(filteredData)
            haditsAdapter.notifyDataSetChanged()
            false
        }
        return false


    }
}