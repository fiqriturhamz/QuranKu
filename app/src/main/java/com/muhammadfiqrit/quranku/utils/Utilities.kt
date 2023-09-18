package com.muhammadfiqrit.quranku.utils

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.muhammadfiqrit.quranku.core.R
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
            tintManager.setStatusBarTintDrawable(ContextCompat.getDrawable(activity, com.muhammadfiqrit.quranku.R.drawable.custom_corner))
        }

    }
}