package com.example.acme.utils.rx;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ScheduleProvider{

    @Inject
    public ScheduleProvider(){}

    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    public Scheduler background() {
        return Schedulers.io();
    }
}