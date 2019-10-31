package com.example.acme.di.module;

import com.example.acme.data.base.remote.Service;
import com.example.acme.ui.MainActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import io.reactivex.disposables.CompositeDisposable;

@Module
public abstract class ApplicationModule {

    @ContributesAndroidInjector
    abstract MainActivity activityInjector();

    @Provides
    static CompositeDisposable provideCompositeDisposable () {
        return new CompositeDisposable();
    }


}
