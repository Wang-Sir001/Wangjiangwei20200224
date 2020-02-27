package com.bawei.wangjiangwei.view.fragment;


import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseFragment;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.adapter.HomeAdapter;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.presenter.HomePresenter;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {

    @BindView(R.id.recy)
    RecyclerView recy;

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {


        Bundle arguments = getArguments();
        int type = arguments.getInt("type");

        presenter.getSongData(2, "15820947584182", type, 1, 5);
    }

    @Override
    public void Success(HomeEntity homeEntity) {
        Log.i("xxx", homeEntity.getResult() + "");
        Log.i("xx",homeEntity.getMessage());

        HomeAdapter homeAdapter = new HomeAdapter(homeEntity.getResult());

        recy.setAdapter(homeAdapter);
    }

    @Override
    public void Error(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public static HomeFragment getInstance(int type) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
}
