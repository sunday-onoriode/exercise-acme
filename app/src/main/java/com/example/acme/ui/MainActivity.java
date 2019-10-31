package com.example.acme.ui;

import android.content.Context;
import android.os.Bundle;

import com.example.acme.App;
import com.example.acme.R;
import com.example.acme.ui.base.BaseActivity;
import com.example.acme.ui.contract.Presenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {


    final  MainFragment mainFragment = MainFragment.getInstance();

    @Inject
    ViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //fragmentContainer  = findViewById(R.id.fragmentContainer);
        addFragment(mainFragment,R.id.fragmentContainer);

       // this.mPresenter = new ViewPresenter();
        mainFragment.attachPresenter(presenter);

        showFragment(mainFragment);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((view)->
            presenter.loadAdvice()
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
