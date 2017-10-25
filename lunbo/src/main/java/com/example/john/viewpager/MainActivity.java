package com.example.john.viewpager;

import android.os.Looper;
import android.support.annotation.IntegerRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.john.viewpager.Fragment.Adapter;
import com.example.john.viewpager.Fragment.ViewPagerDaohang;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{


    private ViewPager mViewPager;
    private RadioGroup rg ;
    private TextView mTextView;
    private Adapter mAdapter;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) this.findViewById(R.id.title);
        mViewPager = (ViewPager) this.findViewById(R.id.viewpager);
        image = (ImageView) this.findViewById(R.id.image_indictor);

        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < 12; i++){

           /*int location = i%4 ;*/
            al.add("第"+i+"条数据");
        }

        mAdapter = new Adapter(getSupportFragmentManager(),al);
        mViewPager.setAdapter(mAdapter);


        rg = (RadioGroup) this.findViewById(R.id.rg);

        ViewPagerDaohang daohang = ViewPagerDaohang.newInstance("fragment1");
        mViewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        int location = position%4;
        float width = rg.getChildAt(location).getX();
        float indictorWidth = positionOffset * positionOffsetPixels;

        float total = width + indictorWidth;
        image.setX(total);

    }

    @Override
    public void onPageSelected(int position) {

        Log.i("mahao",position+"............");
       int location =  (101+position)%4;
        RadioButton radioButton  = (RadioButton) rg.getChildAt(location);
        radioButton.setChecked(true);
       // mTextView.setText(mAdapter.getPageTitle(location));

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
