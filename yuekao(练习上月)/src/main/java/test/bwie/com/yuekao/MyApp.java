package test.bwie.com.yuekao;

import android.app.Application;
import android.content.Context;

/**
 * Created by dell on 2017/10/25.
 */

public class MyApp extends Application {
    private static Context mContext;
    public static MyApp instance;
    public static MyApp getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        FileUtils.CreateDir();//创建错误日志文件夹
        if (CrashConfig.HAVE_LOG) {
            CrashHandler crashHandler = CrashHandler.getInstance();
            crashHandler.init(this.getApplicationContext());
        }
        this.mContext = this;
//        CrashHandler.getInstance().init(this);//初始化全局异常管理


        boolean b = FileUtils.checkFilePathExists(FileUtils.SDPATH);
        StringBuffer buffer = new StringBuffer();
        buffer.append("是否会生成错误日志："+(CrashConfig.HAVE_LOG+""))
                .append("\n\n")
                .append("当前编译模式：")
                .append(BuildConfig.DEBUG ? "debug模式" : "release模式")
                .append("\n\n")
                .append("存放错误日志文件夹是否存在：" + b)
                .append("\n\n")
                .append("存放错误日志文件夹物理路径：")
                .append("\n\n")
                .append(FileUtils.file.getAbsolutePath());
    }

    public static Context getContext(){
        return mContext;
    }
}