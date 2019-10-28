package com.cuncaojin.cloudplay.util

import android.os.Build
import android.util.DisplayMetrics
import android.view.Window

/**
 * @author yg
 * @date 2019/10/28
 */
object ScreenUtil {
    fun getWidthAndHeight(window: Window?): Array<Int?>? {
        if (window == null) {
            return null
        }
        val integer = arrayOfNulls<Int>(2)
        val dm = DisplayMetrics()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.windowManager.defaultDisplay.getRealMetrics(dm)
        } else {
            window.windowManager.defaultDisplay.getMetrics(dm)
        }
        integer[0] = dm.widthPixels
        integer[1] = dm.heightPixels
        return integer
    }
}
