package com.lecturer.lecturer4.androidos.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
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
import com.lecturer.lecturer4.androidos.model.User;
import com.lecturer.lecturer4.androidos.viewmodel.UserViewModel;

public class EditDeleteActivity extends BaseActivity {

    TextView id, appname, applink, applinkname;
    Button deleteBtn, updateBtn;
    UserViewModel viewModel;
    EditText editname, editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);
        init();
    }

    public void init() {
        id = findViewById(R.id.id);
        appname = findViewById(R.id.appname);
        applink = findViewById(R.id.applink);
        applinkname = findViewById(R.id.applinkname);
        editname = findViewById(R.id.editname);
        editpassword = findViewById(R.id.editpassword);

        deleteBtn = findViewById(R.id.deleteButton);
        updateBtn = findViewById(R.id.updateButton);

        Intent i = getIntent();
        if (i != null) {
            id.setText("id1 = " + i.getStringExtra("id"));
            appname.setText("username = " + i.getStringExtra("username"));
            applink.setText("password = " + i.getStringExtra("userpassword"));
            editpassword.setText(i.getStringExtra("userpassword"));
            editname.setText(i.getStringExtra("username"));
        }

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel = ViewModelProviders.of((FragmentActivity) getCtx()).get(UserViewModel.class);
                User o = new User();
                o.setUser_id(i.getStringExtra("id"));
                o.setUser_name(i.getStringExtra("username"));
                o.setUser_password(i.getStringExtra("username"));
                viewModel.deleteUser(o);
                startActivity(new Intent(getApplicationContext(), FormSoftwareActivity.class));
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel = ViewModelProviders.of((FragmentActivity) getCtx()).get(UserViewModel.class);
                User o = new User();
                o.setUser_id(i.getStringExtra("id"));
                o.setUser_name(editname.getText().toString());
                o.setUser_password(editpassword.getText().toString());
                viewModel.updateUser(o);
                startActivity(new Intent(getApplicationContext(), FormSoftwareActivity.class));
            }
        });
    }
}
