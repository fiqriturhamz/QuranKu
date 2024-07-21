package com.muhammadfiqrit.quranku.doa.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.muhammadfiqrit.quranku.R

/**
 * A simple [Fragment] subclass.
 * Use the [DoaHarianFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DoaHarianFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doa_harian, container, false)
    }


}