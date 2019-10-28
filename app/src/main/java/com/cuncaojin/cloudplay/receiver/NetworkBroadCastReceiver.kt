package com.cuncaojin.cloudplay.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

import com.cuncaojin.cloudplay.event.NetworkEvent

import org.greenrobot.eventbus.EventBus

import com.cuncaojin.cloudplay.util.NetStatusUtil

/**
 * @author geyifeng
 * @date 2019-04-22 13:50
 */
class NetworkBroadCastReceiver : BroadcastReceiver() {

    private var mNetworkEvent: NetworkEvent? = null

    private val networkEvent: NetworkEvent
        get() {
            if (mNetworkEvent == null) {
                mNetworkEvent = NetworkEvent()
            }
            return mNetworkEvent as NetworkEvent
        }

    @Suppress("DEPRECATION")
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (ConnectivityManager.CONNECTIVITY_ACTION == action) {
            networkEvent.isAvailable = NetStatusUtil.isNetworkConnected(context)
            EventBus.getDefault().post(mNetworkEvent)
        }
    }
}
