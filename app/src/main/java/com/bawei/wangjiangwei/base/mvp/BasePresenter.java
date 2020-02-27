package com.bawei.wangjiangwei.base.mvp;

import java.lang.ref.WeakReference;

/**
 * 姓名：王江伟
 * 时间：2020年2月24日13:27:54
 * 作用：presenter层基类
 * @param <M> 继承M层
 * @param <V> 继承V层
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    //使用弱引用
    public WeakReference<V> weakReference;

    public BasePresenter() {
        model = initModel();
    }

    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }

    public void detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }

    protected abstract M initModel();

    public V getView(){
        return weakReference.get();
    }
}
