package test.bwie.com.myruanjian1;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.LinearInterpolator;

public class MainHolorActivity extends AppCompatActivity {

    private Myhelorview mMyhelor;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_holor);
        initView();


    }

    private void initView() {
        mMyhelor = (Myhelorview) findViewById(R.id.myhelor);


        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,1000f);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(2000);
        valueAnimator.start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float point = (Float) animation.getAnimatedValue();
                mMyhelor.setX(point);
                mMyhelor.setY(point+460);
            }
        });

        valueAnimator.start();

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                 startActivity(new Intent(MainHolorActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        valueAnimator.cancel();
    }
}
