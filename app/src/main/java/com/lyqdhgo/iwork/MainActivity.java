package com.lyqdhgo.iwork;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

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

}
