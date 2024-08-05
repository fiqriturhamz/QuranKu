package com.muhammadfiqrit.quranku.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.databinding.ItemListAyatBinding
import com.muhammadfiqrit.quranku.di.adapterModule


class AyatAdapter(private val detailSuratViewModel: DetailSuratViewModel) :
    RecyclerView.Adapter<AyatAdapter.AyatViewHolder>() {
    var listAyat: ArrayList<Ayat> = ArrayList()
    private var statusFavorite: Boolean = false
    fun setListAyat(newListData: List<Ayat>?) {
        if (newListData == null) return
        listAyat.clear()
        listAyat.addAll(newListData)
        notifyDataSetChanged()

    }

    inner class AyatViewHolder(var binding: ItemListAyatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.ivLastRead.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val ayat = listAyat[position]
                    val newState = !ayat.isLastRead
                    detailSuratViewModel.setAyatTerakhirDibaca(
                        ayat.copy(isLastRead = newState),
                        newState
                    )
                    Log.d("AyatAdapter", "Clicked ayat: $ayat, new state: $newState")
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyatViewHolder {
        return AyatViewHolder(
            ItemListAyatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AyatViewHolder, position: Int) {
        val ayat = listAyat[position]

        holder.apply {
            binding.nomorAyat.text = ayat.nomorAyat.toString()
            binding.teksArab.text = ayat.teksArab
            binding.teksIndonesia.text = ayat.teksIndonesia
            binding.teksLatin.text = ayat.teksLatin
            binding.ivLastRead.isSelected = ayat.isLastRead
        }
    }


    override fun getItemCount(): Int = listAyat.size
}