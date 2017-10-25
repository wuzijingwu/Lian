package test.bwie.com.yuekao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.bwie.com.yuekao.R;

/**
 * Created by dell on 2017/10/25.
 */

public class Myzhuye extends Fragment {

    private View inflate;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String[] er = new String[]{"最新日报", "专栏", "热门", "主题日报"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.myzhuye, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = inflate.findViewById(R.id.tab1);
        viewPager = inflate.findViewById(R.id.viewpag1);

        for (int i = 0; i < er.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(er[i]));
        }
        viewPager.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment f = null;
                switch (er[position]) {
                    case "最新日报":
                        f = new Diyiye();
                        break;
                    case "专栏":
                        f = new Dierye();

                        break;
                    case "热门":
                        f = new Disanye();

                        break;
                    case "主题日报":
                        f = new Disiye();

                        break;


                }


                return f;
            }

            @Override
            public int getCount() {
                return er.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return er[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);


    }
}
