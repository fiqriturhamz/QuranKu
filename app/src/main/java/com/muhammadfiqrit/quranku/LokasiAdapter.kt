package com.muhammadfiqrit.quranku

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.R
import com.muhammadfiqrit.quranku.core.databinding.ItemListLokasiBinding
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import com.muhammadfiqrit.quranku.lokasi.LokasiViewModel

class LokasiAdapter(private val context: Context, private val lokasiViewModel: LokasiViewModel) :
    RecyclerView.Adapter<LokasiAdapter.LokasiViewHolder>() {
    private var listDataLokasi = ArrayList<Lokasi>()
    fun setData(newListData: List<Lokasi>?) {
        if (newListData == null) return
        listDataLokasi.clear()
        listDataLokasi.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LokasiViewHolder =
        LokasiViewHolder(
            ItemListLokasiBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


    override fun onBindViewHolder(holder: LokasiViewHolder, position: Int) {
        val data = listDataLokasi[position]
        var lokasiSekarang = data.lokasiSekarang
        holder.apply {
            binding.tvNamaLokasi.text = data.namaLokasi
            binding.tvIdLokasi.text = data.idLokasi
            binding.layoutListLokasi.setOnClickListener {
                lokasiSekarang = !lokasiSekarang
                lokasiViewModel.setLokasiSekarang(data, lokasiSekarang)
            }

            if (lokasiSekarang) {
                binding.ivLokasiSekarang.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_check
                    )
                )
                binding.layoutListLokasi.setBackgroundResource(R.drawable.custom_card_current_location)


            } else {
                binding.ivLokasiSekarang.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_uncheck
                    )
                )
                binding.layoutListLokasi.setBackgroundResource(R.drawable.custom_card_not_current_location)
            }
        }
    }

    override fun getItemCount(): Int {
        return listDataLokasi.size
    }

    inner class LokasiViewHolder(var binding: ItemListLokasiBinding) :
        RecyclerView.ViewHolder(binding.root)


}