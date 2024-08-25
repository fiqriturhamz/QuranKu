package com.muhammadfiqrit.quranku.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat

import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir
import com.muhammadfiqrit.quranku.databinding.ItemListTafsirBinding
import com.muhammadfiqrit.quranku.detail.ayat.GenericDiffCallback

class TafsirAdapter(private val detailSuratViewModel: DetailSuratViewModel) :
    RecyclerView.Adapter<TafsirAdapter.TafsirViewHolder>() {
    var listTafsir: ArrayList<Tafsir> = ArrayList()

    inner class TafsirViewHolder(var binding: ItemListTafsirBinding) : ViewHolder(binding.root)

    fun setListTafsir(newListData: List<Tafsir>?) {
        if (newListData == null) return
        val diffCallback = GenericDiffCallback(
            listTafsir,
            newListData,
            compareItems = { oldItem, newItem -> oldItem.teks == newItem.teks }, compareContents =
            { oldItem, newItem -> oldItem == newItem })
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listTafsir.clear()
        listTafsir.addAll(newListData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TafsirViewHolder {
        return TafsirViewHolder(
            ItemListTafsirBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TafsirViewHolder, position: Int) {
        val tafsir = listTafsir[position]
        holder.apply {
            binding.tvTafsir.text = tafsir.teks
            binding.nomorAyat.text = tafsir.ayat.toString()
            if (tafsir.isLastRead) {
                binding.ivLastRead.setImageResource(R.drawable.ic_tag_light)

            } else {
                binding.ivLastRead.setImageResource(R.drawable.ic_tag_dark)
            }
            binding.ivLastRead.setOnClickListener {
                val newState = !tafsir.isLastRead
                detailSuratViewModel.setTafsirTerakhirDibaca(
                    tafsir.copy(isLastRead = newState), newState
                )
                notifyItemChanged(position)

            }
        }
    }

    override fun getItemCount(): Int = listTafsir.size
}