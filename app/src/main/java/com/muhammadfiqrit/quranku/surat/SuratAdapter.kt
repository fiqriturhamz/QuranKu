package com.muhammadfiqrit.quranku.surat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.databinding.ItemListSuratBinding

class SuratAdapter() : RecyclerView.Adapter<SuratAdapter.SuratViewHolder>() {
    private var listData = ArrayList<Surat>()

    var onItemClick: ((Surat) -> Unit)? = null

    fun setData(newListData: List<Surat>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class SuratViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListSuratBinding.bind(itemView)
        fun bind(data: Surat) {
            with(binding) {
                tvNamaLatin.text = data.namaLatin
                tvNomorSurat.text = data.nomor.toString()
                tvJumlahAyat.text = "${data.jumlahAyat} Ayat"
                tvArti.text = data.arti
                tvNamaSurat.text = data.nama
                tvTempatTurun.text = data.tempatTurun
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuratViewHolder = SuratViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list_surat, parent, false)

    )


    override fun onBindViewHolder(holder: SuratViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

}