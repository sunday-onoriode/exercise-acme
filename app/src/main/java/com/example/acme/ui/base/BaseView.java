package com.example.acme.ui.base;

public interface BaseView <T extends BasePresenter> {

    void attachPresenter(T presenter);
    void close();

}
