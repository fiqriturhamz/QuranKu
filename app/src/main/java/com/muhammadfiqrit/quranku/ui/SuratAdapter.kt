package com.muhammadfiqrit.quranku.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.databinding.ItemListSuratBinding
import com.muhammadfiqrit.quranku.ui.surat.SuratFragment

class SuratAdapter : RecyclerView.Adapter<SuratAdapter.SuratViewHolder>() {
    private var listData = ArrayList<SuratEntity>()

    fun setData(newListData: List<SuratEntity>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class SuratViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListSuratBinding.bind(itemView)
        fun bind(data: SuratEntity) {
            with(binding) {
                namaSurat.text = data.namaSurat
                nomorSurat.text = data.nomorSurat.toString()
                jumlahAyat.text = data.jumlahAyat.toString()
                arti.text = data.arti
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuratAdapter.SuratViewHolder = SuratViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list_surat, parent, false)
    )


    override fun onBindViewHolder(holder: SuratAdapter.SuratViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size
}