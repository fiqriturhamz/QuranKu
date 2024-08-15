package com.muhammadfiqrit.quranku.husna

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.domain.model.husna.Husna
import com.muhammadfiqrit.quranku.databinding.ItemListHusnaBinding


class HusnaAdapter() :
    RecyclerView.Adapter<HusnaAdapter.HusnaViewHolder>() {

   private var listHusna = ArrayList<Husna>()
    fun setListHusna(newListHusna: List<Husna>?) {
        if (newListHusna == null) return
        listHusna.clear()
        listHusna.addAll(newListHusna)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HusnaViewHolder {
        return HusnaViewHolder(
            ItemListHusnaBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

        )
    }

    override fun onBindViewHolder(holder: HusnaViewHolder, position: Int) {
        val husna = listHusna[position]
        holder.apply {
            binding.tvNomorHusna.text = husna.id.toString()
            binding.tvTeksArab.text = husna.teksArab
            binding.tvTeksIndo.text = husna.teksIndo
            binding.tvTeksLatin.text = husna.teksLatin
        }
    }

    override fun getItemCount(): Int {
        return listHusna.size
    }

    inner class HusnaViewHolder(var binding: ItemListHusnaBinding) :
        RecyclerView.ViewHolder(binding.root)
}