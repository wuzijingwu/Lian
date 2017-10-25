package test.bwie.com.yekao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import test.bwie.com.yekao.bean.YunDong;
import test.bwie.com.yekao.ok.OkHttp;

public class MainActivity extends AppCompatActivity {

    List<YunDong.DataBean> data = new ArrayList<>();
    ;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager linearLayoutManager;
    private String path = "http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=";
    private int p = 1;
    private ImageLoader imageLoader;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipRefresh);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                p++;
                getDates();
                myadapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == data.size() - 1) {
                    p++;
                    getDates();
                    myadapter.notifyDataSetChanged();
                }
            }
        });


        getDates();
    }

    public void getDates() {
        OkHttp.getAsync(path + p, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                YunDong yunDong = gson.fromJson(result, YunDong.class);
                List<YunDong.DataBean> data = yunDong.getData();
                myadapter = new Myadapter(data);
                recyclerView.setAdapter(myadapter);

            }
        });


    }

    class Myadapter extends RecyclerView.Adapter {

        List<YunDong.DataBean> data;
        private final DisplayImageOptions options;

        public Myadapter(List<YunDong.DataBean> data) {
            this.data = data;
            imageLoader = ImageLoader.getInstance();
            File file = new File(Environment.getExternalStorageDirectory(), "Bwei");
            if (!file.exists())
                file.mkdirs();

            ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(MainActivity.this)
                    .diskCache(new UnlimitedDiskCache(file))
                    .build();

            imageLoader.init(configuration);

            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .cacheOnDisk(true)
                    .build();
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 3 == 0) {
                return 0;

            } else {
                return 1;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            if (viewType == 0) {
                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, parent, false);
                return new MyViewHolder(inflate);
            } else {
                View inflate1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, parent, false);
                return new MyViewHolder1(inflate1);
            }


        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case 0:
                    MyViewHolder myviewholder = (MyViewHolder) holder;
                    myviewholder.textView1.setText(data.get(position).getTitle());
                    getimage(data.get(position).getImg(), myviewholder.imageView1);
                    myviewholder.textView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);


                        }
                    });
                    myviewholder.imageView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);


                        }
                    });


                    break;
                case 1:
                    MyViewHolder1 myviewholder1 = (MyViewHolder1) holder;
                    myviewholder1.textView2.setText(data.get(position).getTitle());
                    getimage(data.get(position).getImg(), myviewholder1.imageView2);
                    myviewholder1.textView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);


                        }
                    });
                    myviewholder1.imageView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);


                        }
                    });


                    break;
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private final TextView textView1;
            private final ImageView imageView1;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView1 = itemView.findViewById(R.id.text);
                imageView1 = itemView.findViewById(R.id.image);

            }
        }

        class MyViewHolder1 extends RecyclerView.ViewHolder {

            private final TextView textView2;
            private final ImageView imageView2;

            public MyViewHolder1(View itemView) {
                super(itemView);
                textView2 = itemView.findViewById(R.id.text2);
                imageView2 = itemView.findViewById(R.id.image2);

            }
        }
    }

    public void getimage(String path, ImageView imageView) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();
        ImageLoader.getInstance().displayImage(path, imageView, options);


    }
}
