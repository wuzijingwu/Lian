package text.bwei.com.kaoshisan.view;

/**
 * Created by dell on 2017/11/18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import text.bwei.com.kaoshisan.R;
import text.bwei.com.kaoshisan.view.common.PlayerManager;

//import com.bwie.test.liuhaifeng20171118.R;
//import com.bwie.test.liuhaifeng20171118.common.PlayerManager;

public class VideoActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener{
    private PlayerManager player;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Intent intent=getIntent();
        url = intent.getStringExtra("url");
        if(url !=null){
            initPlayer();

        }
    }
    private void initPlayer() {

        //初始化播放器
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onPlay() {

    }
    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
    }

}