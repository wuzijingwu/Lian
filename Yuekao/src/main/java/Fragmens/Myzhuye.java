package Fragmens;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;


import test.bwie.com.myruanjian1.R;


public class Myzhuye extends Fragment {


    private View view;

    private ViewPager mVps;
    private TabLayout mTab;
    String[] en = new String[]{"最新日报","主题日报"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myzhuye, container, false);


        initView(v);
        return v;
    }

    private void initView(View v) {
        mTab = (TabLayout) v.findViewById(R.id.tab);
        mVps = (ViewPager) v.findViewById(R.id.vps);


        for(int j = 0 ; j < en.length; j ++){
             mTab.addTab(mTab.newTab().setText(en[j]));
        }

        mVps.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment f = null;
                switch (en[position]){
                    case "最新日报":
                            f = new Zuixinribao();
                        break;
                    case "主题日报":

                            f= new Zhutiribao();
                        break;
                }
                return f;
            }

            @Override
            public int getCount() {
                return en.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return en[position];
            }
        });

        mTab.setupWithViewPager(mVps);
    }
}
