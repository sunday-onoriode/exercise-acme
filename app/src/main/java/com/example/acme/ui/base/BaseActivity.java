package com.example.acme.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment activeFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);

    }


    protected void addFragment(Fragment fragment, int containerId){
        if(fragmentManager.findFragmentByTag(fragment.getClass().getSimpleName())==null) {
            fragmentManager.beginTransaction()
                    .add(containerId, fragment, fragment.getClass().getSimpleName())
                    .hide(fragment)
                    .commit();
            activeFragment = fragment;
        }

    }



    protected  void showFragment(Fragment fragment){

        if(activeFragment==null)activeFragment=fragment;
        fragmentManager
                .beginTransaction()
                .hide(activeFragment)
                .show(fragment).commit();

        activeFragment=fragment;
    }

}
