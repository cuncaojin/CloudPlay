package com.cuncaojin.cloudplay.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author yg
 * @date 2019/10/28
 */
object NetStatusUtil {
    @Suppress("DEPRECATION")
    fun isNetworkConnected(context: Context?): Boolean {
        if (context != null) {
            val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mNetworkInfo = manager.activeNetworkInfo
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable
            }
        }
        return false
    }
}
