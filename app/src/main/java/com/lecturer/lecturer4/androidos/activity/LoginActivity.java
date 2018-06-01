package com.lecturer.lecturer4.androidos.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lecturer.lecturer4.androidos.R;
import com.lecturer.lecturer4.androidos.aabase.BaseActivity;
import com.lecturer.lecturer4.androidos.listener.OnActionListener;
import com.lecturer.lecturer4.androidos.model.MsApplication;
import com.lecturer.lecturer4.androidos.model.User;
import com.lecturer.lecturer4.androidos.viewmodel.UserViewModel;

import java.util.List;

public class LoginActivity extends BaseActivity implements  View.OnClickListener{
    private static final String TAG = LoginActivity.class.getSimpleName();

    Button login;
    EditText userId, password;
    TextView version;
    UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_button);
        version = findViewById(R.id.version);

        login.setOnClickListener(this);
        viewModel = ViewModelProviders.of((FragmentActivity) getCtx()).get(UserViewModel.class);

        for(int i=1;i<=3;i++) {
            User o = new User();
            o.setUser_id("link"+i);
            o.setUser_name("Android");
            o.setUser_password("password");
            viewModel.addUser(o);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        login();
    }

    private void login(){
        if(!validate()){
            return;
        }
        viewModel.getLiUserViewModel(new OnActionListener() {
            @Override
            public void onOk(List<User> list) {

                viewModel = ViewModelProviders.of((FragmentActivity) getCtx()).get(UserViewModel.class);
                User o = new User();
                o.setUser_id(userId.getText().toString());
                viewModel.getUser(o , new CallbackCheckPassword(){
                    @Override
                    public void checkPassword(String result) {
                        // Do something when download finished
                        if(password.getText().toString().equals(result)){
                            startActivity(new Intent(getApplicationContext(), FormSoftwareActivity.class));
                            finish();
                        } else {
                            Log.d(TAG, "checkPassword: no such user");
                        }
                    }
                });

//
//                for(int i=0;i<list.size();i++){
//                    if(userId.getText().toString().equals(list.get(i).getUser_id()) && password.getText().toString().equals(list.get(i).getUser_password())){
//                        startActivity(new Intent(getApplicationContext(), FormSoftwareActivity.class));
//                        finish();
//                    } else {
//                        System.out.println("lol");
//                    }
//                }
            }
        });
    }


    public boolean validate() {
        boolean valid = true;

        if (userId.getText().toString().isEmpty()) {
            userId.setError("User ID tidak boleh kosong");
            valid = false;
        } else {
            userId.setError(null);
        }

        if (password.getText().toString().isEmpty()) {
            password.setError("Password tidak boleh kosong");
            valid = false;
        } else {
            password.setError(null);
        }
        return valid;
    }
}