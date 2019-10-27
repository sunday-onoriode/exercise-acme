package com.example.acme.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.acme.R;
import com.example.acme.adapter.AdviceAdapter;
import com.example.acme.ui.contract.Presenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFragment extends Fragment implements com.example.acme.ui.contract.View {

    private static MainFragment instance;
    private Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    static MainFragment getInstance() {
        if(instance == null) instance = new MainFragment();
        return  instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            //
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.main_fragment, container, false);
        mRecyclerView = root.findViewById(R.id.list);
        swipeRefreshLayout = root.findViewById(R.id.swipe_refresh);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return  root;
    }

    @Override
    public void attachPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void close() {

    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        mPresenter.loadAdvice();
    }

    @Override
    public void onLoadComplete(@NonNull List<String> advises) {
        //Log.e("LOADED",advises.size()+"");
        swipeRefreshLayout.setRefreshing(false);
        AdviceAdapter adviceAdapter = new AdviceAdapter(getActivity(), advises);
        mRecyclerView.setAdapter(adviceAdapter);

    }

    @Override
    public void onLoadError(@NonNull Throwable error) {

        swipeRefreshLayout.setRefreshing(false);

        List<String> defaultAdvice =  Arrays.asList(getString(R.string.default_message),
                getString(R.string.default_message_second));
        AdviceAdapter adviceAdapter = new AdviceAdapter(getActivity(), defaultAdvice);
        mRecyclerView.setAdapter(adviceAdapter);
    }

    @Override
    public void onLoading() {
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.detachView();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}
