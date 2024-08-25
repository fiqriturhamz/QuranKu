package com.muhammadfiqrit.quranku.utils

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.icu.util.GregorianCalendar
import android.icu.util.IslamicCalendar
import android.os.Build
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.doa.DoaAdapter
import com.muhammadfiqrit.quranku.doa.DoaViewModel
import com.readystatesoftware.systembartint.SystemBarTintManager

object Utilities {


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBarGradiant(activity: Activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // set status bar transparent
            val window: Window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

            // set status bar gradient
            val tintManager = SystemBarTintManager(activity)
            tintManager.setStatusBarTintEnabled(true)
            tintManager.setStatusBarTintDrawable(
                ContextCompat.getDrawable(
                    activity,
                    com.muhammadfiqrit.quranku.R.drawable.custom_corner
                )
            )
        }

    }

    val hijriahDate: String
        get() {

            val islamicCalendar = IslamicCalendar()
            val gregorianCalendar = GregorianCalendar()

            val hijriMonthNames = arrayOf(
                "Muharram",
                "Safar",
                "Rabi' al-awwal",
                "Rabi' al-Thani",
                "Jumada al-Awwal",
                "Jumada al-Thani",
                "Rajab",
                "Sha'ban",
                "Ramadan",
                "Shawwal",
                "Dhu al-Qi'dah",
                "Dhu al-Hijjah"
            )

            val gregorianDay = gregorianCalendar.get(android.icu.util.Calendar.DAY_OF_MONTH)
            val gregorianYear = gregorianCalendar.get(android.icu.util.Calendar.YEAR)

            val hijriMonthIndex = islamicCalendar.get(android.icu.util.Calendar.MONTH)
            val hijriMonth = hijriMonthNames[hijriMonthIndex]
            val hijriDate = "$gregorianDay $hijriMonth $gregorianYear"
            return hijriDate
        }

    fun populateData(
        keyword: String,
        doaViewModel: DoaViewModel,
        lifecycleOwner: LifecycleOwner,
        recyclerView: RecyclerView,
        doaAdapter: DoaAdapter,
        context: Context,

        ) {
        doaViewModel.setKeyword(keyword)
        doaViewModel.doa.observe(lifecycleOwner) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        val doaKeyword =
                            it.data?.filter { it.source.contains(keyword, ignoreCase = true) }
                        doaAdapter.setDataDoa(doaKeyword)

                        recyclerView.adapter = doaAdapter
                        recyclerView.layoutManager = LinearLayoutManager(context)
                        recyclerView.setHasFixedSize(true)
                    }

                    is Resource.Error -> {
                        Log.e("error", "${it.message}")
                        Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    fun capitalizeFirstLetter(text: String): String {
        return text.take(1).toUpperCase() + text.drop(1)
    }


}