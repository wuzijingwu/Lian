package test.bwie.com.yi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView image1;
    private TextView tv1;
    private TextView tv2;
    private ImageView image2;
    private TextView tv3;
    private ImageView image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        image1 = (ImageView) findViewById(R.id.image1);
        tv2 = (TextView) findViewById(R.id.tv2);
        image2 = (ImageView) findViewById(R.id.image2);
        tv3 = (TextView) findViewById(R.id.tv3);
        image3 = (ImageView) findViewById(R.id.image3);
        setImage1();
        setImage2();




    }

    private void setImage2() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.decodeResource(getResources(),R.drawable.jd_buy_icon,options);
        //该属性设置为true只会加载图片的边框进来，并不会加载图片具体的像素点
        options.inJustDecodeBounds = true;
        //定义缩放比例
        int inSampleSize = 1;
        //获得原图的宽和高
        int width = options.outWidth;
        int height = options.outHeight;

        while (width / inSampleSize > 500 || height / inSampleSize > 600) {
            inSampleSize *= 2;
        }



        options.inJustDecodeBounds = false;
        //设置缩放比例
        options.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.jd_buy_icon,options);

        //将二次采样后的图片放在image2上
        image2.setImageBitmap(bitmap);
        showBitmap(bitmap, tv2);
    }

    private void setImage1() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jd_buy_icon, null);
        image1.setImageBitmap(bitmap);
        showBitmap(bitmap,tv1);

    }

    private void showBitmap(Bitmap bitmap, TextView tv) {
        if(bitmap!=null){
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            int size = bitmap.getRowBytes() * bitmap.getHeight();
            //图片的内存大小
            String strSize = Formatter.formatFileSize(this, size);
            tv.setText(tv.getText() + "---" + width + "*" + height + "---" + size + "---" + strSize);
        }
    }
}
