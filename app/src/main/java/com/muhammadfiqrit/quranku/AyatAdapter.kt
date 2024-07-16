package com.muhammadfiqrit.quranku

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.databinding.ItemListAyatBinding
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat


class AyatAdapter(private val ayatViewModel: AyatViewModel) :
    RecyclerView.Adapter<AyatAdapter.AyatViewHolder>() {
    var listAyat: ArrayList<Ayat> = ArrayList()

    fun setListAyat(newListData: List<Ayat>?) {
        if (newListData == null) return
        listAyat.clear()
        listAyat.addAll(newListData)
        notifyDataSetChanged()

    }

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
        var ayatTerakhirDibaca = ayat.ayatTerakhirDibaca
        Log.e("ayatTerakhir", ayatTerakhirDibaca.toString())
        holder.apply {
            binding.nomorAyat.text = ayat.nomorAyat.toString()
            binding.teksArab.text = ayat.teksArab
            binding.teksIndonesia.text = ayat.teksIndonesia
            binding.teksLatin.text = ayat.teksLatin
            binding.layoutAyat.setOnClickListener {
                ayatTerakhirDibaca = true
                Log.e("ayatTerakhir", ayat.ayatTerakhirDibaca.toString())
                ayatViewModel.setAyatTerakhirDibaca(ayat, ayatTerakhirDibaca)

            }
        }
    }


    override fun getItemCount(): Int = listAyat.size
}