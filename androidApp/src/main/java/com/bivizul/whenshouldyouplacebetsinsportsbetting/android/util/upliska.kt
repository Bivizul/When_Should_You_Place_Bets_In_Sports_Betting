package com.bivizul.thebeginnersguidetobettingonformula1.util

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import java.text.SimpleDateFormat
import java.util.*

fun getSpliskal() = Locale.getDefault().language

fun getSpliskat(): String {
    val timeZone = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var zone = "00:00"
    if (timeZone.length > 3) {
        zone = timeZone.substring(3)
    }
    return zone
}

fun getSpliskasim(context: Context): String {
    val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telephonyManager.simCountryIso
}

fun getSpliskamm(): String {
    val manufactured = android.os.Build.MANUFACTURER
    val model = android.os.Build.MODEL
    return "$manufactured $model"
}

fun getSpliskadia(context: Context, activity: Activity) {
    AlertDialog.Builder(context).apply {
        setTitle("Error")
        setMessage("Please reboot app")
        setPositiveButton("Quit") { _, _ ->
            activity.finishAndRemoveTask()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

fun getSpliskaid(pref: SharedPreferences): String {
    var spliskaid = pref.getString("spliska", "noSpliska") ?: "noSpliska"
    if (spliskaid == "noSpliska") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        spliskaid = datetime + randomNum
        pref.edit().putString("spliska", spliskaid).apply()
    }
    return spliskaid
}

fun checkSpliskanet(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}


