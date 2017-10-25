package test.bwie.com.yuekao.Utils;

/**
 * Created by dell on 2017/10/25.
 */

import okhttp3.Request;


public interface Icalff<T> {
    public   void Result(T response);
    public void onError(Request request, Exception e);
}