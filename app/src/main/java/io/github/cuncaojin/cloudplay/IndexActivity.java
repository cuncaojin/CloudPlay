package io.github.cuncaojin.cloudplay;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class IndexActivity extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private LinearLayout mLlMain;
    private Toolbar mToolbar;
    private FrameLayout mContent;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindowState();
        setContentView(R.layout.activity_index);

        initView();
        initToolBar();
        initNavigationView();
    }

    private void initNavigationView() {
        //设置菜单图标颜色避免变成灰色
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item0:
                        Snackbar.make(mContent, item.getTitle(), Snackbar
                                .LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item1:
                        Snackbar.make(mContent, item.getTitle(), Snackbar
                                .LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item2:
                        Snackbar.make(mContent, item.getTitle(), Snackbar
                                .LENGTH_SHORT).show();
                        break;
                    case R.id.anvigation_sub_item0:
                        Snackbar.make(mContent, item.getTitle(), Snackbar
                                .LENGTH_SHORT).show();
                        break;
                    case R.id.anvigation_sub_item1:
                        Snackbar.make(mContent, item.getTitle(), Snackbar
                                .LENGTH_SHORT).show();
                        break;
                    case R.id.anvigation_sub_item2:
                        Snackbar.make(mContent, item.getTitle(), Snackbar
                                .LENGTH_SHORT).show();
                        break;
                    case R.id.anvigation_sub_item3:
                        Snackbar.make(mContent, item.getTitle(), Snackbar
                                .LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void initWindowState() {
/*        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/

        //透明状态栏1
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private void initToolBar() {
//        注意：如果使用 setSupportActionBar，则Toolbar.inflateMenu()无效，使用默认菜单配置Activity.onCreateOptionsMenu
//        setSupportActionBar(mToolbar);
//        mToolbar.setTitle("Title");
//        mToolbar.setSubtitle("subTitle");
//        mToolbar.setLogo(R.drawable.ic_house);
//        mToolbar.setNavigationIcon(R.drawable.ic_navigation_next_1);
//        mToolbar.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDrawerlayout.openDrawer(Gravity.LEFT);
//            }
//        });

        //侧滑菜单开关，关联toolbar和Drawlayout
//        // 實作 drawer toggle 並放入 toolbar
//        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
//        mDrawerToggle.syncState();
//        mDrawerlayout.addDrawerListener(mDrawerToggle);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.LEFT;
        View subView = View.inflate(this, R.layout.custom_view_toolbar_left, null);
        initCustomToolbarSubView(subView);
        mToolbar.addView(subView, params);

        mToolbar.inflateMenu(R.menu.menu_toolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_favorite:
                        Snackbar.make(mContent, "favorite", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.action_come:
                        Snackbar.make(mContent, "come baby", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Snackbar.make(mContent, "settings", Snackbar.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


    }

    private void initCustomToolbarSubView(View subView) {
        final ImageView imageView = (ImageView) subView.findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0.5f, 1);
                valueAnimator.setDuration(300);
                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.e("aaaaa", (Float) animation.getAnimatedValue() + "----" + animation.getAnimatedFraction());
                        Float value = (Float) animation.getAnimatedValue();
                        imageView.setScaleX(value);
                        imageView.setScaleY(value);

                        if (animation.getAnimatedFraction() == 1) {
                            if (mDrawerlayout.isDrawerOpen(mNavigationView)) {
                                mDrawerlayout.closeDrawer(mNavigationView);
                            } else {
                                mDrawerlayout.openDrawer(mNavigationView);
                            }
                        }

                    }
                });
                valueAnimator.start();
            }
        });

        Spinner spinner = (Spinner) subView.findViewById(R.id.spinner);
        final String[] mItems = getResources().getStringArray(R.array.tempArray);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner.setAdapter(adapter);
        //防止自动首次进入页面触发选择事件
        spinner.setSelection(0, true);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                if (view != null) {
                    ((TextView) view).setTextColor(getResources().getColor(R.color.text_color_white));
                    Snackbar.make(mContent, mItems[pos], Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    private void initView() {
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mLlMain = (LinearLayout) findViewById(R.id.ll_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContent = (FrameLayout) findViewById(R.id.content);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_favorite:
//                Snackbar.make(mContent, "favorite", Snackbar.LENGTH_SHORT).show();
//                break;
//            case R.id.action_come:
//                Snackbar.make(mContent, "come baby", Snackbar.LENGTH_SHORT).show();
//                break;
//            case R.id.action_settings:
//                Snackbar.make(mContent, "settings", Snackbar.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
