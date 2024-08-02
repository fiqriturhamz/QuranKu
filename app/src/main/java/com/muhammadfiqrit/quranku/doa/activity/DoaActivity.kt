package com.muhammadfiqrit.quranku.doa.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.databinding.ActivityDoaBinding
import com.muhammadfiqrit.quranku.doa.fragment.DoaHaditsFragment
import com.muhammadfiqrit.quranku.doa.fragment.DoaHajiFragment
import com.muhammadfiqrit.quranku.doa.fragment.DoaHarianFragment
import com.muhammadfiqrit.quranku.doa.fragment.DoaIbadahFragment
import com.muhammadfiqrit.quranku.doa.fragment.DoaLainnyaFragment
import com.muhammadfiqrit.quranku.doa.fragment.DoaPilihanFragment
import com.muhammadfiqrit.quranku.doa.fragment.DoaQuranFragment
import com.muhammadfiqrit.quranku.doa.fragment.TabDoaAdapter

class DoaActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    companion object {
        @StringRes
        private val DETAIL_TAB_DOA = intArrayOf(
            R.string.doa_tab_text_0,
            R.string.doa_tab_text_1,
            R.string.doa_tab_text_2,
            R.string.doa_tab_text_3,
            R.string.doa_tab_text_4,
            R.string.doa_tab_text_5,
            R.string.doa_tab_text_6
        )
    }

    private lateinit var binding: ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*     val tabDoaAdapter = TabDoaAdapter(this)
        binding.viewpagerDoa.adapter = tabDoaAdapter
        TabLayoutMediator(binding.tabsDoa, binding.viewpagerDoa) { tabs, position ->
            val tabText = when (position) {
                0 -> "Quran"
                1 -> "Hadits"
                2 -> "Pilihan"
                3 -> "Harian"
                4 -> "Ibadah"
                5 -> "Haji"
                6 -> "Lainnya"
                else -> "Lainnya"
            }
            tabs.customView = createTabView(tabText)
            tabs.contentDescription = tabText

        }.attach()

        binding.tabsDoa.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabTextView = (tab.customView as? TextView)
                tabTextView?.setTextColor(ContextCompat.getColor(this@DoaActivity, R.color.pink))

                Log.d("DoaActivity", "Tab selected: ${tab.contentDescription}")
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabTextView = (tab.customView as? TextView)
                tabTextView?.setTextColor(ContextCompat.getColor(this@DoaActivity, R.color.black))
                Log.d("DoaActivity", "Tab unselected: ${tab.contentDescription}")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun createTabView(text: String): View {
        val tabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        val tabTextView = tabView.findViewById<TextView>(R.id.tabTextView)
        tabTextView.text = text
        tabTextView.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.pink
            )
        ) // Set default color to black
        Log.d("MainActivity", "Tab created: $text")

        return tabView
    }*/

        setSupportActionBar(binding.toolbar)
        binding.navView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.open,
            R.string.close
        )
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.pink)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, DoaQuranFragment())
                .commit()
            binding.navView.setCheckedItem(R.id.quran)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.quran) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, DoaQuranFragment())
                .commit()
        } else if (item.itemId == R.id.haji) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, DoaHajiFragment())
                .commit()
        } else if (item.itemId == R.id.harian) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, DoaHarianFragment())
                .commit()
        } else if (item.itemId == R.id.ibadah) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, DoaIbadahFragment())
                .commit()
        } else if (item.itemId == R.id.pilihan) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, DoaPilihanFragment()).commit()
        } else if (item.itemId == R.id.hadits) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, DoaHaditsFragment())
                .commit()
        } else if (item.itemId == R.id.lainnya) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, DoaLainnyaFragment())
                .commit()
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}