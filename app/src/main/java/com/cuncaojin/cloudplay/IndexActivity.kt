package com.cuncaojin.cloudplay

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.*
import com.cuncaojin.cloudplay.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_index.*

class IndexActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        // initToolBar()
        // initNavigationView()
    }

    // private fun initNavigationView() {/*设置菜单图标颜色避免变成灰色*/
    //     navigationView!!.itemIconTintList = null
    //     navigationView!!.setNavigationItemSelectedListener { item ->
    //         when (item.itemId) {
    //             R.id.navigation_item0 -> Snackbar.make(navigationView!!, item.title, Snackbar.LENGTH_SHORT).show()
    //             R.id.navigation_item1 -> Snackbar.make(navigationView!!, item.title, Snackbar.LENGTH_SHORT).show()
    //             R.id.navigation_item2 -> Snackbar.make(navigationView!!, item.title, Snackbar.LENGTH_SHORT).show()
    //             R.id.anvigation_sub_item0 -> Snackbar.make(navigationView!!, item.title, Snackbar.LENGTH_SHORT).show()
    //             R.id.anvigation_sub_item1 -> Snackbar.make(navigationView!!, item.title, Snackbar.LENGTH_SHORT).show()
    //             R.id.anvigation_sub_item2 -> Snackbar.make(navigationView!!, item.title, Snackbar.LENGTH_SHORT).show()
    //             R.id.anvigation_sub_item3 -> Snackbar.make(navigationView!!, item.title, Snackbar.LENGTH_SHORT).show()
    //             else -> {
    //             }
    //         }
    //         false
    //     }
    // }

    /*        注意：如果使用 setSupportActionBar，则Toolbar.inflateMenu()无效，使用默认菜单配置Activity.onCreateOptionsMenu setSupportActionBar(mToolbar); mToolbar.setTitle("Title"); mToolbar.setSubtitle("subTitle"); mToolbar.setLogo(R.drawable.ic_house); mToolbar.setNavigationIcon(R.drawable.ic_navigation_next_1); mToolbar.setOverScrollMode(View.OVER_SCROLL_ALWAYS); mToolbar.setNavigationOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { mDrawerlayout.openDrawer(Gravity.LEFT); } });*/
    /*侧滑菜单开关，关联toolbar和Drawlayout // 實作 drawer toggle 並放入 toolbar ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolbar, R.string.drawer_open, R.string.drawer_close); mDrawerToggle.syncState(); mDrawerlayout.addDrawerListener(mDrawerToggle);*/
    // private fun initToolBar() {
    //     val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    //     params.gravity = Gravity.LEFT
    //     val subView = View.inflate(this, R.layout.custom_view_toolbar_left, null)
    //     initCustomToolbarSubView(subView)
    //
    //     toolbar!!.addView(subView, params)
    //     toolbar!!.inflateMenu(R.menu.menu_toolbar)
    //     toolbar!!.setOnMenuItemClickListener { item ->
    //         when (item.itemId) {
    //             R.id.action_favorite -> Snackbar.make(toolbar!!, "favorite", Snackbar.LENGTH_SHORT).show()
    //             R.id.action_come -> Snackbar.make(toolbar!!, "come baby", Snackbar.LENGTH_SHORT).show()
    //             R.id.action_settings -> Snackbar.make(toolbar!!, "settings", Snackbar.LENGTH_SHORT).show()
    //             else -> {
    //             }
    //         }
    //         false
    //     }
    // }

    // private fun initCustomToolbarSubView(subView: View) {
    //     val imageView = subView.findViewById<View>(R.id.imageView) as ImageView
    //     imageView.setOnClickListener {
    //         val valueAnimator = ValueAnimator.ofFloat(1f, 0.5f, 1f).setDuration(300)
    //         valueAnimator.interpolator = AccelerateDecelerateInterpolator()
    //         valueAnimator.addUpdateListener { animation ->
    //             Log.e("aaaaa", (animation.animatedValue as Float).toString() + "----" + animation.animatedFraction)
    //             val value = animation.animatedValue as Float
    //             imageView.scaleX = value
    //             imageView.scaleY = value
    //             if (animation.animatedFraction == 1f) if (drawerlayout!!.isDrawerOpen(navigationView!!)) drawerlayout!!.closeDrawer(navigationView!!)
    //             else drawerlayout!!.openDrawer(navigationView!!)
    //         }
    //         valueAnimator.start()
    //     }
    //     val spinner = subView.findViewById<View>(R.id.spinner) as Spinner
    //     val mItems = resources.getStringArray(R.array.tempArray)/* 建立Adapter并且绑定数据源*/
    //     val adapter = ArrayAdapter(this, R.layout.spinner_item, mItems)
    //     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)/*绑定 Adapter到控件*/
    //     spinner.adapter = adapter/*防止自动首次进入页面触发选择事件*/
    //     spinner.setSelection(0, true)
    //     spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    //         override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
    //             if (view != null) {
    //                 (view as TextView).setTextColor(resources.getColor(R.color.text_color_white))
    //                 Snackbar.make(parent, mItems[pos], Snackbar.LENGTH_SHORT).show()
    //             }
    //         }
    //
    //         override fun onNothingSelected(parent: AdapterView<*>) {/* Another interface callback*/
    //         }
    //     }
    // }

}
