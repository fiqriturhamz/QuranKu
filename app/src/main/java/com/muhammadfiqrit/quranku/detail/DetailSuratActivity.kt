package com.muhammadfiqrit.quranku.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.databinding.ActivityDetailSuratBinding
import com.muhammadfiqrit.quranku.detail.ayat.AyatFragment
import com.muhammadfiqrit.quranku.detail.tafsir.TafsirFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailSuratActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SURAT_NOMOR = "extra_surat_nomor"
        const val EXTRA_SURAT_NOMOR_FOR_FRAGMENT = "extra_surat_nomor_for_fragment"

        @StringRes
        private val DETAIL_TAB_TITLES =
            intArrayOf(R.string.detail_tab_text_1, R.string.detail_tab_text_2)
    }

    private lateinit var binding: ActivityDetailSuratBinding
    private val detailSuratViewModel: DetailSuratViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuratBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabTafsirAyatAdapter = TabTafsirAyatAdapter(this)
        binding.viewpagerAyatTafsir.adapter = tabTafsirAyatAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerAyatTafsir) { tab, position ->
            tab.text = resources.getString(DETAIL_TAB_TITLES[position])
        }.attach()

        val suratNomor = intent.getIntExtra(EXTRA_SURAT_NOMOR, 1)

        AyatFragment.suratNomor = suratNomor
        TafsirFragment.suratNomor = suratNomor

        populateDataDetail(suratNomor)

    }

    private fun populateDataDetail(suratNomor: Int) {
        suratNomor.let { detailSuratViewModel.setId(it) }
        detailSuratViewModel.suratDetail.observe(this) {
            if (it != null) {
                when (it) {
                    is com.muhammadfiqrit.quranku.core.data.Resource.Loading ->{}

                    is com.muhammadfiqrit.quranku.core.data.Resource.Success -> {

                        it.data?.let { detailSurat ->
                            binding.tvDetailArtiSurat.text = detailSurat.surat.arti
                            binding.tvDetailTempatTurun.text = detailSurat.surat.tempatTurun
                            binding.tvDetailNamaLatin.text = detailSurat.surat.namaLatin
                            binding.tvDetailNamaSurat.text = detailSurat.surat.nama
                            binding.tvDetailNomorSurat.text = detailSurat.surat.nomor.toString()

                            /*  val ayatAdapter = AyatAdapter(detailSurat.ayat)
                              binding.rvAyat.layoutManager = LinearLayoutManager(this)
                              binding.rvAyat.setHasFixedSize(true)
                              binding.rvAyat.adapter = ayatAdapter*/
                            /*
                                                        var statusFavorite = false
                                                        setStatusFavorite(statusFavorite)*/

                            /*           binding.fabFavorite.setOnClickListener {

                                           Log.e("status_favorite", statusFavorite.toString())
                                           statusFavorite = !statusFavorite
                                           detailSuratViewModel.setFavoriteSurat(
                                               detailSurat,
                                               statusFavorite
                                           )
                                           setStatusFavorite(statusFavorite)
                                       }*/
                        }
                    }

                    is com.muhammadfiqrit.quranku.core.data.Resource.Error -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }

    }

    /*    private fun setStatusFavorite(statusFavorite: Boolean) {
            if (statusFavorite) {
                binding.fabFavorite.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        com.muhammadfiqrit.quranku.R.drawable.favorite_white
                    )
                )
            } else {
                binding.fabFavorite.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        com.muhammadfiqrit.quranku.R.drawable.not_favorite_white
                    )
                )
            }
        }*/

}