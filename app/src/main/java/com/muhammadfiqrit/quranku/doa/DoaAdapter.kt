package com.muhammadfiqrit.quranku.doa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.domain.model.doa.Doa
import com.muhammadfiqrit.quranku.databinding.ItemListDoaBinding

class DoaAdapter : RecyclerView.Adapter<DoaAdapter.DoaViewHolder>() {
    private val listDoa = ArrayList<Doa>()

    fun setDataDoa(newListData: List<Doa>?) {
        if (newListData == null) return
        listDoa.clear()
        listDoa.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaAdapter.DoaViewHolder {
        return DoaViewHolder(
            ItemListDoaBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DoaAdapter.DoaViewHolder, position: Int) {
        val doa = listDoa[position]
        holder.apply {
            binding.doaJudul.text = doa.judul
            binding.tvDoaTeksArab.text = doa.teksArab
            binding.tvDoaTeksIndo.text = doa.teksIndo
        }
    }

    override fun getItemCount(): Int {
        return listDoa.size
    }

    inner class DoaViewHolder(var binding: ItemListDoaBinding) :
        RecyclerView.ViewHolder(binding.root)
}