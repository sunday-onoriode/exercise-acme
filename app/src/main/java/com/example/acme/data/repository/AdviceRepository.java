package com.example.acme.data.repository;

import com.example.acme.data.base.remote.Service;
import com.example.acme.data.remote.AdviceService;
import com.example.acme.model.AdviceResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class AdviceRepository {

    private  Retrofit mService = Service.getRetrofitInstance();


    public Observable<AdviceResponse> loadAdvice (){

        mService.create(AdviceService.class);
        return mService.create(AdviceService.class).getAdvice();

    }

}
