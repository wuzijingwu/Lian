package test.bwie.com.myruanjian1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 白玉春 on 2017/10/25.
 */

public class Myhelorview extends View {

    private Paint paint ;
    private int Redio;

    public Myhelorview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint  = new Paint();

        paint.setColor(Color.GRAY);

        paint.setAntiAlias(true);

        paint.setColor(Color.BLUE);

        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Redio = 44;
        canvas.drawCircle(55,55,Redio,paint);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width = widthSize;
        int height = heightSize;

        setMeasuredDimension(width,height);
    }
}
