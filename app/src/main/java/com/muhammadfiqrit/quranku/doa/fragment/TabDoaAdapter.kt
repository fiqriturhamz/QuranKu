package com.muhammadfiqrit.quranku.doa.fragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.muhammadfiqrit.quranku.doa.activity.DoaActivity

class TabDoaAdapter(activity: DoaActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = DoaQuranFragment()
            1 -> fragment = DoaHaditsFragment()
            2 -> fragment = DoaPilihanFragment()
            3 -> fragment = DoaHarianFragment()
            4 -> fragment = DoaIbadahFragment()
            5 -> fragment = DoaHajiFragment()
            6 -> fragment = DoaLainnyaFragment()
        }
        return fragment as Fragment
    }

}