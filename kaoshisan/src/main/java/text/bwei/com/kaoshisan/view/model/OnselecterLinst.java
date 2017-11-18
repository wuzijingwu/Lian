package text.bwei.com.kaoshisan.view.model;

import java.util.List;

import text.bwei.com.kaoshisan.view.bean.News;

/**
 * Created by dell on 2017/11/18.
 */

public interface OnselecterLinst {
    void dataSuccess(List<News.DataBean> list);
    void dataError(String s);

}
