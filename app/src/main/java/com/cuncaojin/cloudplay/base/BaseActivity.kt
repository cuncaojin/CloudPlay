package com.cuncaojin.cloudplay.base

import android.os.Bundle

import butterknife.ButterKnife
import butterknife.Unbinder
import com.cuncaojin.cloudplay.R
import com.gyf.immersionbar.ImmersionBar
import me.yokeyword.fragmentation.SupportActivity

/**
 * @author yg
 * @date 2019/10/28
 */
open class BaseActivity : SupportActivity() {

    private var mUnbinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUnbinder = ButterKnife.bind(this)
        initImmersionBar()
    }

    /**
     * 设置共同沉浸式样式
     */
    open fun initImmersionBar() {
        ImmersionBar.with(this).navigationBarColor(R.color.colorPrimary).init()
    }

    override fun onDestroy() {
        super.onDestroy()
        mUnbinder?.unbind()
    }
}
