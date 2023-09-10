package com.muhammadfiqrit.quranku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.databinding.ActivityDetailSuratBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSuratActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SURAT_NOMOR = "extra_surat_nomor"
    }

    private lateinit var binding: ActivityDetailSuratBinding
    private val detailSuratViewModel: DetailSuratViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuratBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val suratNomor = intent.getIntExtra(EXTRA_SURAT_NOMOR,0)

        populateDataDetail(suratNomor)


        Log.e("suratNomor", suratNomor.toString())


    }

    private fun populateDataDetail(suratNomor: Int) {
        suratNomor.let { detailSuratViewModel.setId(it) }
        detailSuratViewModel.suratDetail.observe(this) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> binding.detailProgressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.detailProgressBar.visibility = View.GONE
                        it.data?.let { surat ->
                            binding.tvDetailArtiSurat.text = surat.arti
                            binding.tvDetailNamaSurat.text = surat.namaSurat
                            binding.tvDetailNomorSurat.text = surat.nomorSurat.toString()

                            binding.rvAyat.layoutManager = LinearLayoutManager(this)
                            binding.rvAyat.setHasFixedSize(true)
                            binding.rvAyat.adapter = AyatAdapter(surat.ayat)
                        }
                    }

                    is Resource.Error -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        binding.detailProgressBar.visibility = View.GONE
                    }
                }
            }
        }
    }
}