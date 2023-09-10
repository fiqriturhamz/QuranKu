package com.muhammadfiqrit.quranku.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.muhammadfiqrit.quranku.databinding.ItemListAyatBinding
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat

class AyatAdapter(private val listAyat: List<Ayat>) :
    RecyclerView.Adapter<AyatAdapter.AyatViewHolder>() {
    inner class AyatViewHolder(var binding: ItemListAyatBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyatAdapter.AyatViewHolder {
        return AyatViewHolder(
            ItemListAyatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AyatAdapter.AyatViewHolder, position: Int) {
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