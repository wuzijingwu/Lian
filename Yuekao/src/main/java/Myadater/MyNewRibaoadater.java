package Myadater;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Bean.MynewRibao;
import test.bwie.com.myruanjian1.R;

/**
 * Created by 白玉春 on 2017/10/24.
 */

public class MyNewRibaoadater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<MynewRibao.StoriesBean> list;
    List<MynewRibao.TopStoriesBean> top;
    List<ImageView> imagelist;
    //当前索引位置以及上一个索引位置
    private int indexs = 0,preIndex = 0;


    public MyNewRibaoadater(Context context, List<MynewRibao.StoriesBean> list, List<MynewRibao.TopStoriesBean> top) {
        this.context = context;
        this.list = list;
        this.top = top;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View V = null;
        if(viewType == 0 ){
            return  new OneViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
        }else if(viewType == 1 ) {
            return new TwoViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
        }

        return new TwoViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

         if(holder instanceof  OneViewholder){

             Handler handler = new Handler(){
                 @Override
                 public void handleMessage(Message msg) {
                     super.handleMessage(msg);
                     switch (msg.what){
                         case 1:
                               indexs++;
                                ((OneViewholder) holder).viewPager1.setCurrentItem(indexs);

                             sendEmptyMessageDelayed(1,1000);
                             break;
                     }
                 }
             };

             final ImageView[] images = new ImageView[]{((OneViewholder) holder).i1,((OneViewholder) holder).i2,((OneViewholder) holder).i3,((OneViewholder) holder).i4,((OneViewholder) holder).i5};

             ((OneViewholder) holder).viewPager1.setAdapter(new PagerAdapter() {
                 @Override
                 public int getCount() {
                     return Integer.MAX_VALUE;
                 }

                 @Override
                 public boolean isViewFromObject(View view, Object object) {

                     return view == object;
                 }

                 @Override
                 public Object instantiateItem(ViewGroup container, int position) {

                     ImageView imageView = new ImageView(context);

                     imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                     int  index = position%top.size();

                     ImageLoader.getInstance().displayImage(top.get(index).getImage(),imageView);

                     container.addView(imageView);

                     return imageView;
                 }

                 @Override
                 public void destroyItem(ViewGroup container, int position, Object object) {
                     container.removeView((View) object);
                 }
             });

             ;
             ((OneViewholder) holder).viewPager1.setCurrentItem(1000);

             handler.sendEmptyMessage(1);

             ((OneViewholder) holder).viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                 @Override
                 public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                 }

                 @Override
                 public void onPageSelected(int position) {
                     int  index = position%top.size();
                     for(int i = 0 ; i<images.length; i ++){
                         if(i==index){
                             images[i].setImageResource(R.mipmap.point_selected);
                         }else{
                             images[i].setImageResource(R.mipmap.point_mormal);
                         }
                     }
                 }
                 @Override
                 public void onPageScrollStateChanged(int state) {

                 }
             });
         }

         if(holder instanceof TwoViewholder){
             ((TwoViewholder) holder).t1.setText(list.get(position).getTitle());
              ((TwoViewholder) holder).t2.setText(list.get(position).getGa_prefix());
              List<String> im =    list.get(position).getImages();
             for(int i =0 ; i < im.size() ; i++){
             ImageLoader.getInstance().displayImage(im.get(i),((TwoViewholder) holder).leftimage);
         }
         }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class OneViewholder extends RecyclerView.ViewHolder{
        ViewPager viewPager1;
        ImageView i1;
        ImageView i2;
        ImageView i3;
        ImageView i4;
        ImageView i5;
        public OneViewholder(View itemView) {
            super(itemView);
            viewPager1  = itemView.findViewById(R.id.lunbo);
            i1 = itemView.findViewById(R.id.youtu);
            i2 = itemView.findViewById(R.id.wutu1);
            i3 = itemView.findViewById(R.id.wutu2);
            i4 = itemView.findViewById(R.id.wutu13);
            i5 = itemView.findViewById(R.id.wutu4);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return  0 ;
        }else {
            return 1;
        }
    //    return super.getItemViewType(position);
    }

    class TwoViewholder extends RecyclerView.ViewHolder{
        ImageView leftimage;

        TextView t1;
        TextView t2;
        TextView t3;

        public TwoViewholder(View itemView) {
            super(itemView);

            leftimage = itemView.findViewById(R.id.lefticon);
            t1 =  itemView.findViewById(R.id.t1);
            t2 =  itemView.findViewById(R.id.t2);
            t3 =  itemView.findViewById(R.id.t3);
        }
    }
}
