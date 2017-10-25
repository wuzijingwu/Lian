package Utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 白玉春 on 2017/10/24.
 */

public class Okhttp {

    private static OkHttpClient client;
    private static  Okhttp okhttps;

    public static  Okhttp getOkhttps(){

        if(okhttps == null){
            synchronized (Okhttp.class){
                if(okhttps == null){
                    okhttps =new Okhttp();
                }
            }
        }
        return okhttps;
    }

    public Okhttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new LoggingInterceptor());

        client = builder.build();

    }


    public void GetDatas(String url, final Icalls icalls){

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                icalls.Error(e,request);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 if(response.isSuccessful()){
                     icalls.Success(response.body().string());
                 }else{
                     icalls.Success("请求失败");
                 }
            }
        });

    }
}
