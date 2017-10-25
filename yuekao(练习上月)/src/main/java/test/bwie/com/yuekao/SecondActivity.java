package test.bwie.com.yuekao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import test.bwie.com.yuekao.fragment.Myzhuye;
import test.bwie.com.yuekao.fragment.Wuyong;

/**
 * Created by dell on 2017/10/25.
 */

public class SecondActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;
    String[] str = new String[]{"主页", "我的", "榜单"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        for (int i = 0; i < str.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(str[i]));
        }
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment f=null;
                switch (str[position]) {
                    case "主页":
                        f = new Myzhuye();
                        break;
                    case "我的":
                        f = new Wuyong();
                        break;
                    case "榜单":
                        f = new Wuyong();
                        break;
                }
                return f;
            }

            @Override
            public int getCount() {
                return str.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return str[position];
            }
        });

        tablayout.setupWithViewPager(viewpager);

    }
}
