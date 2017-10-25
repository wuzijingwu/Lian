package test.bwie.com.lian;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {


    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        imageview = (ImageView) findViewById(R.id.imageview);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                pingyi();
                break;
            case R.id.button2:
                xuanzhuan();
                break;
            case R.id.button3:
                suofang();
                break;
            case R.id.button4:
                jianbian();
                break;
            case R.id.button5:
                zuhe();
                break;
        }
    }
    private void zuhe() {
        imageview.animate().translationY(200).rotationX(360).alpha(0.5f).scaleY(2).setDuration(5000); //这种方式只能执行一次
    }
    private void jianbian() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageview, "alpha", 1f, 0f, 0.5f, 0, 1);
        objectAnimator.setDuration(3000).start();
    }

    public void pingyi() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageview, "translationY", 0f, 150f, 56f);
        objectAnimator.setDuration(2000).start();
    }
    public void xuanzhuan() {
        imageview.animate().rotationX(360).setDuration(2000);
    }
    public void suofang() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageview, "scaleX", 1F, 2F, 1F);
        objectAnimator.setDuration(2000).start();
    }


}
