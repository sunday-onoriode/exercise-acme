package com.example.acme.ui.base;

public interface BasePresenter<V> {

    void start();
    void attachView(V  view);
    void detachView();
    void destroy();
    V getView();
}
