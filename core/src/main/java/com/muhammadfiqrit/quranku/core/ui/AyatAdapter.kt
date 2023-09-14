package com.muhammadfiqrit.quranku.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.databinding.ItemListAyatBinding
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat

class AyatAdapter(private val listAyat: List<Ayat>) :
    RecyclerView.Adapter<AyatAdapter.AyatViewHolder>() {
    inner class AyatViewHolder(var binding: ItemListAyatBinding) :
        RecyclerView.ViewHolder(binding.root) {

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

        }
    }

    override fun getItemCount(): Int = listAyat.size
}