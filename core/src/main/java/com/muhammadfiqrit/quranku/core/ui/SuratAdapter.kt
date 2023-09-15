package com.muhammadfiqrit.quranku.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.databinding.ItemListSuratBinding
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat

class SuratAdapter() : RecyclerView.Adapter<SuratAdapter.SuratViewHolder>() {
    private var listData = ArrayList<Surat>()

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(newListData: List<Surat>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class SuratViewHolder(var binding: ItemListSuratBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuratViewHolder = SuratViewHolder(
        ItemListSuratBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    )


    override fun onBindViewHolder(holder: SuratViewHolder, position: Int) {
        val data = listData[position]
        holder.apply {
            binding.tvNamaLatin.text = data.namaLatin
            binding.tvNomorSurat.text = data.nomor.toString()
            binding.tvJumlahAyat.text = "${data.jumlahAyat} Ayat"
            binding.tvArti.text = data.arti
            binding.tvNamaSurat.text = data.nama
            binding.tvTempatTurun.text = data.tempatTurun
            itemView.setOnClickListener {
                onItemClickCallback.onSuratClick(data)
            }
        }
    }

    override fun getItemCount(): Int = listData.size

    interface OnItemClickCallback {
        fun onSuratClick(data: Surat)
    }
}