package test.bwie.com.yuekao.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class Myvpadapter extends PagerAdapter {
    int[] imageicon;
    Context context;
    List<ImageView> imagelist;

    public Myvpadapter(int[] imageicon, Context context,
                       List<ImageView> imagelist) {
        super();
        this.imageicon = imageicon;
        this.context = context;
        this.imagelist = imagelist;
    }

    @Override
    public int getCount() {

        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        // super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView image = imagelist.get(position % imagelist.size());
        container.addView(image);
        return image;
    }

}