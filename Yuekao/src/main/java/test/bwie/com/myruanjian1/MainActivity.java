package test.bwie.com.myruanjian1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import Fragmens.Myzhuye;
import Fragmens.Wuyong;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mTouch;
    private ViewPager mVp;
    private TabLayout mBottomtab;

    String[] str = new String[]{"主页","我的","榜单"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mTouch = (RelativeLayout) findViewById(R.id.touch);
        mVp = (ViewPager) findViewById(R.id.vp);
        mBottomtab = (TabLayout) findViewById(R.id.bottomtab);

        for(int i = 0 ; i< str.length; i++){
            mBottomtab.addTab(mBottomtab.newTab().setText(str[i]));
        }

        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment  f =  null;
                  switch (str[position]){
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

        mBottomtab.setupWithViewPager(mVp);
    }
}
