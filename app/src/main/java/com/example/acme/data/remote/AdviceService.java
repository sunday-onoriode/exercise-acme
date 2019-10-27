package com.example.acme.data.remote;

import com.example.acme.model.AdviceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AdviceService {

    @GET("fortune/")
    Observable<AdviceResponse> getAdvice ();
}
