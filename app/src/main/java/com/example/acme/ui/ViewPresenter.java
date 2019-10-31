package com.example.acme.ui;

import com.example.acme.data.repository.AdviceRepository;
import com.example.acme.ui.contract.Presenter;
import com.example.acme.ui.contract.View;
import com.example.acme.utils.rx.ScheduleProvider;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class ViewPresenter implements Presenter {

    private View mView ;
    private final ScheduleProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private final AdviceRepository adviceRepository;

    @Inject
    public ViewPresenter( ScheduleProvider schedule, CompositeDisposable disposable, AdviceRepository repository){
        this.mCompositeDisposable = disposable;
        this.mSchedulerProvider = schedule;
        this.adviceRepository = repository;
    }


    @Override
    public void loadAdvice() {

        mView.onLoading();

        mCompositeDisposable.add(adviceRepository.loadAdvice()
        .subscribeOn(mSchedulerProvider.background())
        .observeOn(mSchedulerProvider.ui())
        .subscribe(
                (response)-> mView.onLoadComplete(response.getFortune()),
                (throwable)-> mView.onLoadError(throwable)
        ));
    }

    @Override
    public void start() {

    }

    @Override
    public void attachView(View view) {
            this.mView =  view;
    }

    @Override
    public void detachView() {
            this.mView = null;
    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void destroy() {
        mCompositeDisposable.dispose();
    }
}
