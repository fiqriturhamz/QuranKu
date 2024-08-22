package com.muhammadfiqrit.quranku.detail.ayat

import androidx.recyclerview.widget.DiffUtil

class GenericDiffCallback<T>(
    private val oldList: List<T>,
    private val newList: List<T>,
    private val compareItems: (T, T) -> Boolean,
    private val compareContents: (T, T) -> Boolean
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return compareItems(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return compareContents(oldList[oldItemPosition], newList[newItemPosition])
    }

}