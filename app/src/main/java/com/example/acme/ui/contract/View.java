package com.example.acme.ui.contract;

import androidx.annotation.NonNull;

import com.example.acme.ui.base.BaseView;

import java.util.List;

public interface View  extends BaseView<Presenter> {

        void onLoadComplete(@NonNull List<String> advises);
        void onLoadError(@NonNull Throwable error);
        void onLoading();
}
