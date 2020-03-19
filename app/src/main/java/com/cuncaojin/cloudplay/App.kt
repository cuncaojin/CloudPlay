package com.cuncaojin.cloudplay

import android.app.Application
import android.content.Context
import android.text.TextUtils

import androidx.multidex.MultiDex
import com.cuncaojin.cloudplay.base.CommonData
import com.cuncaojin.cloudplay.service.NetworkService

import com.tencent.bugly.crashreport.CrashReport
import me.yokeyword.fragmentation.Fragmentation
import me.yokeyword.fragmentation.helper.ExceptionHandler

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

import top.zibin.luban.BuildConfig

/**
 * @author cuncaojin
 * @date 2017/3/16
 */
class App : Application() {

    lateinit var appContext: Context

    override fun onCreate() {
        super.onCreate()
        appContext = this

        val context = applicationContext
        // 获取当前包名
        val packageName = context.packageName
        // 获取当前进程名
        val processName = getProcessName(android.os.Process.myPid())
        // 设置是否为上报进程
        val strategy = CrashReport.UserStrategy(context)
        strategy.isUploadProcess = processName == null || processName == packageName
        CrashReport.initCrashReport(applicationContext, CommonData.Bugly_APP_ID, BuildConfig.DEBUG, strategy)

        // 网络监听服务
        NetworkService.enqueueWork(this)
        Fragmentation.builder()
                // 设置 栈视图 模式为 （默认）悬浮球模式   SHAKE: 摇一摇唤出  NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.BUBBLE).debug(true) // 实际场景建议.debug(BuildConfig.DEBUG)
                /**
                 * 可以获取到[me.yokeyword.fragmentation.exception.AfterSaveStateTransactionWarning]
                 * 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                 */
                .handleException {
                    // 以Bugtags为例子: 把捕获到的 Exception 传到 Bugtags 后台。Bugtags.sendException(e);
                    CrashReport.postCatchedException(it)
                }.install()
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }

    /**
     * 获取进程号对应的进程名
     * @param pid 进程号
     * @return 进程名
     */
    private fun getProcessName(pid: Int): String? {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName = reader.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim { it <= ' ' }
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                reader?.close()
            } catch (exception: IOException) {
                exception.printStackTrace()
            }

        }
        return null
    }
}
