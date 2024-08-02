package com.muhammadfiqrit.quranku.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfiqrit.quranku.core.domain.model.quote.Quote
import com.muhammadfiqrit.quranku.databinding.ItemListQuotesBinding

class QuoteAdapter : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    private val listQuotes = ArrayList<Quote>()
    fun setDataQuote(newList: List<Quote>?) {
        if (newList == null) return
        listQuotes.clear()
        listQuotes.addAll(newList)
        notifyDataSetChanged()

    }

    fun getDataQuotes() = listQuotes

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuoteAdapter.QuoteViewHolder {
        return QuoteViewHolder(
            ItemListQuotesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: QuoteAdapter.QuoteViewHolder, position: Int) {
        val quotes = listQuotes[position]
        holder.apply {
            binding.tvQuotes.text = quotes.tvQuote
            binding.tvAuthor.text = quotes.tvAuthor
        }
    }

    override fun getItemCount(): Int {
        return listQuotes.size
    }

    inner class QuoteViewHolder(var binding: ItemListQuotesBinding) :
        RecyclerView.ViewHolder(binding.root)
}