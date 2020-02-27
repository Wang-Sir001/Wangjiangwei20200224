package com.bawei.wangjiangwei.util;

import com.bawei.wangjiangwei.api.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 姓名：王江伟
 * 时间：2020年2月24日14:16:34
 * 作用：网络连接工具类
 */
public class NetUtils {
    private static NetUtils netUtils;
    private final Retrofit build;

    private NetUtils(){
        //日志拦截器
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        build = new Retrofit.Builder()
                .baseUrl(API.USER_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static NetUtils getInstance() {
        if (netUtils == null) {
            synchronized (NetUtils.class){
                if (netUtils == null) {
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    public <T>T getCreat(Class<T> tClass){
        return build.create(tClass);
    }
}
