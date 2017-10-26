package test.bwie.com.wanglu;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
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
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private String path = "http://news-at.zhihu.com/api/4/themes";
    private RecyclerView recyclerView;
    private ImageLoader imageLoader;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyc);
        linearLayoutManager = new LinearLayoutManager(this);
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
                Bean bean = gson.fromJson(result, Bean.class);
                List<Bean.OthersBean> others = bean.getOthers();
                recyclerView.setAdapter(new MyAdapter(others));


            }
        });


    }

    class MyAdapter extends RecyclerView.Adapter {

        List<Bean.OthersBean> others;
        private MyViewHolder myviewholder;
        private final DisplayImageOptions options;

        public MyAdapter(List<Bean.OthersBean> others) {
            this.others = others;
//            imageLoader = ImageLoader.getInstance();
//            File file = new File(Environment.getExternalStorageDirectory(), "Bwei");
//            if (!file.exists())
//                file.mkdirs();
//
//            ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(MainActivity.this)
//                    .diskCache(new UnlimitedDiskCache(file))
//                    .build();
//
//            imageLoader.init(configuration);
//            options = new DisplayImageOptions.Builder()
//                    .showImageOnLoading(R.mipmap.ic_launcher)
//                    .cacheOnDisk(true)
//                    .build();


            //创建默认的ImageLoader配置参数
            ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(MainActivity.this);

            //将configuration配置到imageloader中
            imageLoader= ImageLoader.getInstance();
            imageLoader.init(configuration);

            //自定义ImageLoader缓冲目录
            File flie= new File(Environment.getExternalStorageDirectory(),"bawei");
            if(!flie.exists()){
                flie.mkdirs();
            }
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(MainActivity.this)
                    .diskCache(new UnlimitedDiskCache(flie))
                    .build();
            imageLoader.init(config);

            options=new DisplayImageOptions.Builder()
                    //设置下载的图片是否缓存在内存中
                    .cacheInMemory(true)
                    //设置下载的图片是否缓存在SD卡中
                    .cacheOnDisk(true)
                    //设置图片的解码类型
                    .bitmapConfig(Bitmap.Config.ARGB_8888)
                    //设置图片在下载期间显示的图片
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    //设置图片Uri为空或是错误的时候显示的图片
                    .showImageForEmptyUri(R.mipmap.ic_launcher)
                    //设置图片加载/解码过程中错误时候显示的图片
                    .showImageOnFail(R.mipmap.ic_launcher)
                    //图像将被二次采样的整数倍
                    .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                    //设置图片加入缓存前，对bitmap进行设置
                    //.preProcessor(BitmapProcessor preProcessor)
                    // 设置图片在下载前是否重置，复位
                    .resetViewBeforeLoading(true)
                    //是否设置为圆角，弧度为多少
                    .displayer(new RoundedBitmapDisplayer(20))
                    //是否图片加载好后渐入的动画时间
                    .displayer(new FadeInBitmapDisplayer(100))
                    //构建完成
                    .build();



        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, parent, false);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            myviewholder = (MyViewHolder) holder;
            myviewholder.textView.setText(others.get(position).getDescription());
            getimage(others.get(position).getThumbnail(),myviewholder.imageView);

        }

        @Override
        public int getItemCount() {
            return others.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private final ImageView imageView;
            private final TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.images);
                textView = itemView.findViewById(R.id.text);
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
