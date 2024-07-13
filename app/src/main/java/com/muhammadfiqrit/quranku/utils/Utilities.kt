package com.muhammadfiqrit.quranku.utils

import android.annotation.TargetApi
import android.app.Activity
import android.icu.util.GregorianCalendar
import android.icu.util.IslamicCalendar
import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
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

}