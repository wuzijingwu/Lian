package text.bwei.com.kaoshisan.view.Api;

import retrofit2.http.GET;
import rx.Observable;
import text.bwei.com.kaoshisan.view.bean.News;

/**
 * Created by dell on 2017/11/18.
 */

public interface ApiServer {
    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio")
    Observable<News> getData();

    Observable<News> getDasss();

}
