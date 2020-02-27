package com.bawei.wangjiangwei.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 姓名：王江伟
 * 时间：2020年2月24日13:29:15
 * 作用：activity层基类
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        //绑定Butterknife
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
            bind.unbind();
    }
}
