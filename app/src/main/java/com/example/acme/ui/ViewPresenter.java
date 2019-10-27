package com.example.acme.ui;

import com.example.acme.data.repository.AdviceRepository;
import com.example.acme.ui.contract.Presenter;
import com.example.acme.ui.contract.View;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ViewPresenter implements Presenter {

    View mView ;
    private  CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void loadAdvice() {

        mView.onLoading();

        disposable.add(new AdviceRepository().loadAdvice()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
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
        disposable.dispose();
    }
}
