package com.muhammadfiqrit.quranku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.databinding.ActivityDetailSuratBinding
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

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


        val suratNomor = intent.getIntExtra(EXTRA_SURAT_NOMOR, 0)

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
                        it.data?.let { detailSurat ->
                            binding.tvDetailArtiSurat.text = detailSurat.arti
                            binding.tvDetailNamaSurat.text = detailSurat.nama
                            binding.tvDetailNomorSurat.text = detailSurat.nomor.toString()

                            binding.rvAyat.layoutManager = LinearLayoutManager(this)
                            binding.rvAyat.setHasFixedSize(true)


                            var statusFavorite = detailSurat.isFavorite
                            setStatusFavorite(statusFavorite)

                            binding.fabFavorite.setOnClickListener {

                                Log.e("status_favorite", statusFavorite.toString())
                                statusFavorite = !statusFavorite
                                detailSuratViewModel.setFavoriteSurat(
                                    detailSurat,
                                    statusFavorite
                                )
                                setStatusFavorite(statusFavorite)
                            }
                        }
                    }

                    is Resource.Error -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        binding.detailProgressBar.visibility = View.GONE
                    }
                }
            }
        }

        detailSuratViewModel.ayatDetail.observe(this) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> binding.detailProgressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.detailProgressBar.visibility = View.GONE
                        val ayatAdapter = AyatAdapter(it.data!!)
                        binding.rvAyat.layoutManager = LinearLayoutManager(this)
                        binding.rvAyat.setHasFixedSize(true)
                        binding.rvAyat.adapter = ayatAdapter
                    }

                    is Resource.Error -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        binding.detailProgressBar.visibility = View.GONE
                    }
                }
            }

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.favorite_white
                )
            )
        } else {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.not_favorite_white
                )
            )
        }
    }
}