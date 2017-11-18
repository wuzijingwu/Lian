package text.bwei.com.kaoshisan.view;

import java.util.List;

import text.bwei.com.kaoshisan.view.bean.News;

/**
 * Created by dell on 2017/11/18.
 */

public interface Iview {
    void showBannerSuccess(List<News.DataBean> list);
    void showBannerReeor(String s);
    void showRecyc(List<News.DataBean> list);
}
