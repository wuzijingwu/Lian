package text.bwei.com.kaoshisan.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import text.bwei.com.kaoshisan.R;
import text.bwei.com.kaoshisan.view.Api.Api;
import text.bwei.com.kaoshisan.view.bean.News;
import text.bwei.com.kaoshisan.view.presenter.presenter;

/**
 * Created by dell on 2017/11/18.
 */

public class SecondActivity extends AppCompatActivity implements Iview {

    private XBanner banner;
    private text.bwei.com.kaoshisan.view.presenter.presenter presenter;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private Button downloadbutton;
    private Button stopbutton;
    private ProgressBar progressBar;
    private TextView resultView;
    private static final int PROCESSING = 1;
    private static final int FAILURE = -1;
    private MyAdapter.MyViewHolder myViewHolder;
    private Handler handler = new UIHandler();

    private OnItemClickListener mClickListener;
    private TextView text;
    private ImageView image;
    //    private ButtonClickListener listener;
    private MyAdapter myAdapter;


    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mClickListener = listener;
    }


    private final class UIHandler extends Handler {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case PROCESSING: // 更新进度
                    progressBar.setProgress(msg.getData().getInt("size"));
                    float num = (float) progressBar.getProgress()
                            / (float) progressBar.getMax();
                    int result = (int) (num * 100); // 计算进度
                    resultView.setText(result + "%");
                    if (progressBar.getProgress() == progressBar.getMax()) { // 下载完成

                    }
                    break;
                case FAILURE: // 下载失败

                    break;
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        banner = (XBanner) findViewById(R.id.banner);
        downloadbutton = (Button) findViewById(R.id.downloadbutton);
        stopbutton = (Button) findViewById(R.id.stopbutton);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        resultView = (TextView) findViewById(R.id.resultView);
//        TextView textView= (TextView) findViewById(R.id.text);
        //////////////////////
        LayoutInflater layout = this.getLayoutInflater();
        View view = layout.inflate(R.layout.item_recyc, null);
        text = (TextView) view.findViewById(R.id.text);
        image = (ImageView) view.findViewById(R.id.image);
//////////////////////////////////

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        presenter = new presenter(this);
        presenter.getBanner(Api.URL_BU);
        // presenter.getRecyc(Api.URL_BU);


//        image.setOnClickListener(listener);


    }




    @Override
    public void showBannerSuccess(List<News.DataBean> list) {


        List<String> bantitle = new ArrayList<>();
        final List<String> banimg = new ArrayList<>();
//        List<BannerBean.DataBean> data = bb.getData();
        for (int i = 0; i < list.size(); i++) {
            bantitle.add(list.get(i).getTitle());
            banimg.add(list.get(i).getImage_url());
        }
        banner.setData(banimg, bantitle);
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(SecondActivity.this).load(banimg.get(position)).into((ImageView) view);
            }
        });
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);


    }

    class MyAdapter extends RecyclerView.Adapter {
        private List<News.DataBean> list;
        private MyViewHolder myViewHolder;

        private TextView text;
        private ImageView imageView;
        private Button downloadbutton;
        private Button stopbutton;
        private ProgressBar progressBar;
        private TextView resultView;


        //////


        ////////


        public MyAdapter(List<News.DataBean> list) {
            this.list = list;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyc, parent, false));
            return myViewHolder;


        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            myViewHolder = (MyViewHolder) holder;
            News.DataBean dataBean = list.get(position);
            myViewHolder.text.setText(dataBean.getContent());
            ImageLoader.getInstance().displayImage(list.get(position).getImage_url(), myViewHolder.imageView);
            myViewHolder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SecondActivity.this, ThreeActivity.class);
                    intent.putExtra("aaa",list.get(position).getVedio_url());
                    startActivity(intent);
                }
            });
            myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = list.get(position).getVedio_url();
                    Intent intent1=new Intent(SecondActivity.this,VideoActivity.class);
                    intent1.putExtra("url",s);
                    startActivity(intent1);

                }
            });


        }

//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//
//    }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView text;
            private ImageView imageView;
            private Button downloadbutton;
            private Button stopbutton;
            private ProgressBar progressBar;
            private TextView resultView;


            public MyViewHolder(View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
                imageView = itemView.findViewById(R.id.image);


            }
        }


    }


    @Override
    public void showBannerReeor(String s) {
        Log.e("哈哈哈哈哈啊哈哈啊哈哈哈哈哈哈", s);
    }

    @Override
    public void showRecyc(List<News.DataBean> list) {


    }
}
