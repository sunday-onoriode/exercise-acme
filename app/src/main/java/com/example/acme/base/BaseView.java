package com.example.acme.base;

public interface BaseView <T extends BasePresenter> {

    void attachPresenter(T presenter);
    void close();

}
