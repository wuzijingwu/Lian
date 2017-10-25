package test.bwie.com.yuekao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import test.bwie.com.yuekao.R;
import test.bwie.com.yuekao.Utils.OkHttp;
import test.bwie.com.yuekao.bean.Bean1;

/**
 * Created by dell on 2017/10/25.
 */

public class Diyiye extends Fragment {

    private View inflate;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private String path = "http://news-at.zhihu.com/api/4/news/latest";
    private int indexs = 0, preIndex = 0;
    List<Bean1.TopStoriesBean> top=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.diyiye, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = inflate.findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        getDates();


    }

    public void getDates() {
        OkHttp.getAsync(path, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                Bean1 bean1 = gson.fromJson(result.toString(), Bean1.class);
                List<Bean1.StoriesBean> stories = bean1.getStories();
                recyclerView.setAdapter(new MyNewRibaoadater(stories));
            }
        });

    }

    class MyNewRibaoadater extends RecyclerView.Adapter {
        List<Bean1.StoriesBean> stories;

        public MyNewRibaoadater(List<Bean1.StoriesBean> stories) {
            this.stories = stories;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            if (viewType == 0) {

                View inflate1 = LayoutInflater.from(getContext()).inflate(R.layout.item1, parent, false);
                return new MyViewHolder1(inflate1);
            } else {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
                return new MyViewHolder(inflate);
            }


        }


        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


            if (holder instanceof MyViewHolder1) {

                Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        switch (msg.what) {
                            case 1:
                                indexs++;
                                ((MyViewHolder1) holder).viewPager1.setCurrentItem(indexs);

                                sendEmptyMessageDelayed(1, 1000);
                                break;
                        }
                    }
                };

                final ImageView[] images = new ImageView[]{((MyViewHolder1) holder).i1, ((MyViewHolder1) holder).i2, ((MyViewHolder1) holder).i3, ((MyViewHolder1) holder).i4, ((MyViewHolder1) holder).i5};

                ((MyViewHolder1) holder).viewPager1.setAdapter(new PagerAdapter() {
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

                        ImageView imageView = new ImageView(getActivity());

                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                        int index = position % top.size();

                        ImageLoader.getInstance().displayImage(top.get(index).getImage(), imageView);

                        container.addView(imageView);

                        return imageView;
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position, Object object) {
                        container.removeView((View) object);
                    }
                });

                ;
                ((MyViewHolder1) holder).viewPager1.setCurrentItem(1000);

                handler.sendEmptyMessage(1);

                ((MyViewHolder1) holder).viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        int index = position % top.size();
                        for (int i = 0; i < images.length; i++) {
                            if (i == index) {
                                images[i].setImageResource(R.mipmap.point_selected);
                            } else {
                                images[i].setImageResource(R.mipmap.point_mormal);
                            }
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }

            if (holder instanceof MyViewHolder) {
                ((MyViewHolder) holder).t1.setText(stories.get(position).getTitle());
                ((MyViewHolder) holder).t2.setText(stories.get(position).getGa_prefix());
                List<String> im = stories.get(position).getImages();
                for (int i = 0; i < im.size(); i++) {
                    ImageLoader.getInstance().displayImage(im.get(i), ((MyViewHolder) holder).leftimage);
                }
            }

        }

        @Override
        public int getItemCount() {
            return stories.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {


            ImageView leftimage;

            TextView t1;
            TextView t2;
            TextView t3;

            public MyViewHolder(View itemView) {
                super(itemView);

                leftimage = itemView.findViewById(R.id.lefticon);
                t1 = itemView.findViewById(R.id.t1);
                t2 = itemView.findViewById(R.id.t2);
                t3 = itemView.findViewById(R.id.t3);
            }
        }

        class MyViewHolder1 extends RecyclerView.ViewHolder {


            ViewPager viewPager1;
            ImageView i1;
            ImageView i2;
            ImageView i3;
            ImageView i4;
            ImageView i5;

            public MyViewHolder1(View itemView) {
                super(itemView);
                viewPager1 = itemView.findViewById(R.id.lunbo);
                i1 = itemView.findViewById(R.id.youtu);
                i2 = itemView.findViewById(R.id.wutu1);
                i3 = itemView.findViewById(R.id.wutu2);
                i4 = itemView.findViewById(R.id.wutu13);
                i5 = itemView.findViewById(R.id.wutu4);


            }
        }


    }


}
