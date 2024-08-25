package com.muhammadfiqrit.quranku.detail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.databinding.ItemListAyatBinding
import com.muhammadfiqrit.quranku.detail.ayat.GenericDiffCallback
class AyatAdapter(private val detailSuratViewModel: DetailSuratViewModel) :
    RecyclerView.Adapter<AyatAdapter.AyatViewHolder>() {
    var listAyat: ArrayList<Ayat> = ArrayList()
    fun setListAyat(newListData: List<Ayat>?) {


        if (newListData == null) return
        val diffCallback = GenericDiffCallback(
            oldList = listAyat,
            newListData,
            compareItems = { oldItem, newItem -> oldItem.id == newItem.id },
            compareContents = { oldItem, newItem -> oldItem == newItem }
        )
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listAyat.clear()
        listAyat.addAll(newListData)
        diffResult.dispatchUpdatesTo(this)

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

        holder.apply {

            binding.nomorAyat.text = ayat.nomorAyat.toString()
            binding.teksArab.text = ayat.teksArab
            binding.teksIndonesia.text = ayat.teksIndonesia
            binding.teksLatin.text = ayat.teksLatin
            if (ayat.isLastRead) {
                binding.ivLastRead.setImageResource(R.drawable.ic_tag_light)
            } else {
                binding.ivLastRead.setImageResource(R.drawable.ic_tag_dark)
            }

            binding.ivLastRead.setOnClickListener {
                val newState = !ayat.isLastRead
                detailSuratViewModel.setAyatTerakhirDibaca(
                    ayat.copy(isLastRead = newState),
                    newState
                )
                notifyItemChanged(position)
            }
            binding.ivShare.setOnClickListener {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, ayat.teksIndonesia)
                    type = "text/plain"
                    setPackage("com.whatsapp")
                }
                try {
                    holder.itemView.context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(
                        holder.itemView.context,
                        "Whatsapp tidak terpasang",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }


    override fun getItemCount(): Int = listAyat.size


}