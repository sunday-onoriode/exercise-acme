package com.example.acme.data.repository;

import com.example.acme.data.base.remote.Service;
import com.example.acme.data.remote.AdviceService;
import com.example.acme.model.AdviceResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AdviceRepository {

    @Inject
    Service mService;

    @Inject
    public AdviceRepository(){
    }


    public Observable<AdviceResponse> loadAdvice (){
        return mService.create(AdviceService.class).getAdvice();
    }

}
