package com.bawei.wangjiangwei.presenter;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.base.mvp.IBaseView;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.HomeModel;
import com.bawei.wangjiangwei.model.entity.HomeEntity;

public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresenter {
    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getSongData(int userId, String sessionId, int type, int page, int size) {
        model.getSongData(userId, sessionId, type, page, size, new IHomeContract.IModel.ModelCallback() {
            @Override
            public void Success(HomeEntity homeEntity) {
                getView().Success(homeEntity);
            }

            @Override
            public void Error(Throwable throwable) {
                getView().Error(throwable);
            }
        });
    }
}
