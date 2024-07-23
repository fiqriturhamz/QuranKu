package com.muhammadfiqrit.quranku.hadits

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.domain.model.hadits.Hadits
import com.muhammadfiqrit.quranku.databinding.ItemListHaditsBinding

class HaditsAdapter : RecyclerView.Adapter<HaditsAdapter.HaditsViewHolder>() {
    private val listHadits = ArrayList<Hadits>()
    fun setData(newListData: List<Hadits>?) {
        if (newListData == null) return
        listHadits.clear()
        listHadits.addAll(newListData)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HaditsAdapter.HaditsViewHolder {
        return HaditsViewHolder(
            ItemListHaditsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HaditsAdapter.HaditsViewHolder, position: Int) {
        val hadits = listHadits[position]
        holder.apply {
            binding.tvNoHadits.text = hadits.nomorHadits
            binding.teksIndonesia.text = hadits.teksIndo
            binding.tvJudulHadits.text = hadits.judulHadits
            binding.tvTeksArabHadits.text = hadits.teksArab
        }
    }

    override fun getItemCount(): Int {
        return listHadits.size
    }

    inner class HaditsViewHolder(var binding: ItemListHaditsBinding) :
        RecyclerView.ViewHolder(binding.root)
}