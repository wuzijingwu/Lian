package text.bwei.com.kaoshisan.view.presenter;

import java.util.List;

import text.bwei.com.kaoshisan.view.Iview;
import text.bwei.com.kaoshisan.view.bean.News;
import text.bwei.com.kaoshisan.view.model.Imodel;
import text.bwei.com.kaoshisan.view.model.Onrecycler;
import text.bwei.com.kaoshisan.view.model.OnselecterLinst;
import text.bwei.com.kaoshisan.view.model.model;

/**
 * Created by dell on 2017/11/18.
 */

public class presenter {

    Imodel imodel;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getBanner(String url) {
        imodel.RequestSuccess(url, new OnselecterLinst() {
            @Override
            public void dataSuccess(List<News.DataBean> list) {
                iview.showBannerSuccess(list);
            }

            @Override
            public void dataError(String s) {
                iview.showBannerReeor(s);
            }
        });


    }


    public void getRecyc(String url){
        imodel.RequestRecyc(url, new Onrecycler() {
            @Override
            public void datarecyc(List<News.DataBean> list) {
                iview.showRecyc(list);
            }
        });


    }



}
