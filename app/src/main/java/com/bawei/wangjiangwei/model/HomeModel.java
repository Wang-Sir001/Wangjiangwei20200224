package com.bawei.wangjiangwei.model;

import com.bawei.wangjiangwei.api.HomeServiseApi;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getSongData(int userId, String sessionId, int type, int page, int size, ModelCallback modelCallback) {
        NetUtils.getInstance().getCreat(HomeServiseApi.class)
                .getHomeData(userId,sessionId,type,page,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeEntity homeEntity) {
                        modelCallback.Success(homeEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.Error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
