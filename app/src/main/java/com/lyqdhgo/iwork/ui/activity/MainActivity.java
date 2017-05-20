package com.lyqdhgo.iwork.ui.activity;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.lyqdhgo.iwork.R;
import com.lyqdhgo.iwork.base.BaseMainFragment;
import com.lyqdhgo.iwork.ui.fragment.contacts.ContactFragment;
import com.lyqdhgo.iwork.ui.helper.BottomNavigationViewHelper;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SupportActivity implements BaseMainFragment.OnBackToFirstListener {
    public static final int FIRST = 0;

    private SupportFragment[] mFragments = new SupportFragment[4];

    BottomNavigationView navigation;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(navigation);

        if (savedInstanceState == null) {
            mFragments[FIRST] = ContactFragment.newInstance();

            loadMultipleRootFragment(R.id.container, FIRST, mFragments[FIRST]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(ContactFragment.class);
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int position = item.getItemId();
            switch (position) {
                case R.id.bottom_navigation_blue:
                    Log.i("TAG", "Email");
                    return true;
                case R.id.bottom_navigation_green:
                    Log.i("TAG", "Chat");
                    return true;
                case R.id.bottom_navigation_gray:
                    Log.i("TAG", "Contacts");
                    return true;
                case R.id.bottom_navigation_yellow:
                    Log.i("TAG", "Work");
                    return true;
                case R.id.bottom_navigation_red:
                    Log.i("TAG", "Me");
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackToFirstFragment() {

    }
}
