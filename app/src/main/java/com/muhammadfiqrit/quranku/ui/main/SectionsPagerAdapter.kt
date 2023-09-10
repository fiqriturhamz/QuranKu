package com.muhammadfiqrit.quranku.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.muhammadfiqrit.quranku.ui.favorite.FavoriteFragment
import com.muhammadfiqrit.quranku.ui.home.HomeFragment
import com.muhammadfiqrit.quranku.ui.surat.SuratFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = SuratFragment()
            2 -> fragment = FavoriteFragment()
        }
        return fragment as Fragment
    }

}