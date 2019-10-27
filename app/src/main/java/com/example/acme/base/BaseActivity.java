package com.example.acme.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class BaseActivity extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment activeFragment;


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
