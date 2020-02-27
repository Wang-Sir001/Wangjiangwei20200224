package com.bawei.wangjiangwei.api;

import com.bawei.wangjiangwei.model.entity.HomeEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface HomeServiseApi {
    @GET("live-user/verify/findGiftRecordByUid")
    Observable<HomeEntity> getHomeData(@Header("userId") int userId,
                                       @Header("sessionId") String sessionId,
                                       @Query("type") int type,
                                       @Query("page") int page,
                                       @Query("size") int size);
}
