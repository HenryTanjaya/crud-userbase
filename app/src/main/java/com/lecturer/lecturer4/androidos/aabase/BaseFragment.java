package com.lecturer.lecturer4.androidos.aabase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;

import com.lecturer.lecturer4.androidos.listener.OnChangeLayoutListener;

/**
 * Created by IT on 1/23/2018.
 */

public class BaseFragment extends Fragment {

    protected boolean isRotated = false;
    protected Bundle args;
    protected static final String ARGS_INSTANCE = "com.lecturer.lecturer3.androidos.basefragmentargs";

    protected Context getCtx(){
        return getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isRotated = savedInstanceState != null;
        this.args = getArguments();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}