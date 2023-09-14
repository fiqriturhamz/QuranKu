package com.muhammadfiqrit.quranku.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.muhammadfiqrit.quranku.favorite.FavoriteFragment
import com.muhammadfiqrit.quranku.home.HomeFragment
import com.muhammadfiqrit.quranku.surat.SuratFragment

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