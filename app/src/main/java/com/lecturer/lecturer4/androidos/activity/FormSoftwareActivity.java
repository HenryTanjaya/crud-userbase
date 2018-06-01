package com.lecturer.lecturer4.androidos.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lecturer.lecturer4.androidos.R;
import com.lecturer.lecturer4.androidos.aabase.BaseActivity;
import com.lecturer.lecturer4.androidos.aabase.BaseFragment;
import com.lecturer.lecturer4.androidos.fragments.UserFragment;
import com.lecturer.lecturer4.androidos.listener.OnChangeLayoutListener;
import com.lecturer.lecturer4.androidos.model.User;

public class FormSoftwareActivity extends BaseActivity implements OnChangeLayoutListener{

    private BaseFragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_software);

        if(savedInstanceState == null){
            doChangeLayout(UserFragment.newInstance(1));
        }else{
            BaseFragment baseFragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag("ifrgmt");
            doChangeLayout(baseFragment);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_refresh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(activeFragment instanceof UserFragment){ doFinish(); }
        else super.onBackPressed();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void doChangeLayout(BaseFragment fragment){
        loadFragment( fragment);
    }

    @Override
    public void doBackPress(){
        onBackPressed();
    }

    @Override
    public void doFinish(){
        finish();
    }

    @Override
    public void setActiveFragment(BaseFragment o){
        this.activeFragment = o;
    }

    private void loadFragment(BaseFragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.your_placeholder, fragment, "ifrgmt");
        fragmentTransaction.commit();
    }
}