package com.muhammadfiqrit.quranku.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.muhammadfiqrit.quranku.detail.ayat.AyatFragment
import com.muhammadfiqrit.quranku.detail.tafsir.TafsirFragment

class TabTafsirAyatAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = AyatFragment()
            1 -> fragment = TafsirFragment()
        }
        return fragment as Fragment
    }
}