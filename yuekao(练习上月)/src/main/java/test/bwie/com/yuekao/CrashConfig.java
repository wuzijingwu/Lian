package test.bwie.com.yuekao;

/**
 * Created by dell on 2017/10/25.
 */

public class CrashConfig {
    public static final boolean DEBUG = BuildConfig.DEBUG;
    public static final boolean HAVE_LOG = DEBUG ? true : false;//debug产生错误日志
//    public static final String HAVE_LOG = DEBUG ? false : true;//release产生错误日志
}