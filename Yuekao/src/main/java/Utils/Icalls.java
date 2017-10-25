package Utils;

import okhttp3.Request;

/**
 * Created by 白玉春 on 2017/10/24.
 */

public interface Icalls<T>  {  //泛型

    void Success(T t);
    void Error(Exception e, Request request);
}
