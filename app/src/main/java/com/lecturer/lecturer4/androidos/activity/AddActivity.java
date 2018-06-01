package com.lecturer.lecturer4.androidos.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.lecturer.lecturer4.androidos.R;
import com.lecturer.lecturer4.androidos.aabase.BaseActivity;
import com.lecturer.lecturer4.androidos.model.User;
import com.lecturer.lecturer4.androidos.viewmodel.UserViewModel;

public class AddActivity extends BaseActivity {

    TextView username, userid, userpassword;
    Button adduser;
    UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        userid = findViewById(R.id.userId);
        username = findViewById(R.id.userName);
        userpassword= findViewById(R.id.userPassword);
        adduser = findViewById(R.id.add_account);

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel = ViewModelProviders.of((FragmentActivity) getCtx()).get(UserViewModel.class);
                User o = new User();
                o.setUser_id(userid.getText().toString());
                o.setUser_name(username.getText().toString());
                o.setUser_password(userpassword.getText().toString());
                viewModel.addUser(o);
                username.setText("");
                userpassword.setText("");
                userid.setText("");
            }
        });
    }
}
