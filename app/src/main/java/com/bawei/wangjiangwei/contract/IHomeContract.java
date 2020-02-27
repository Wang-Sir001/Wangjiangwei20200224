package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.base.mvp.IBaseModel;
import com.bawei.wangjiangwei.base.mvp.IBaseView;
import com.bawei.wangjiangwei.model.entity.HomeEntity;

/**
 * 姓名：王江伟
 * 时间：2020年2月24日13:55:59
 * 作用：契约类
 */
public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getSongData(int userId,String sessionId,int type,int page,int size,ModelCallback modelCallback);

        interface ModelCallback{
            void Success(HomeEntity homeEntity);
            void Error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void Success(HomeEntity homeEntity);
        void Error(Throwable throwable);
    }
    interface IPresenter{
        void getSongData(int userId,String sessionId,int type,int page,int size);
    }
}
