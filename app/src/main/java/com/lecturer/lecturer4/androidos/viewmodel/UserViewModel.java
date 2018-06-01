package com.lecturer.lecturer4.androidos.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.lecturer.lecturer4.androidos.activity.CallbackCheckPassword;
import com.lecturer.lecturer4.androidos.db.AppDatabase;
import com.lecturer.lecturer4.androidos.helper.AsyncTaskUtils;
import com.lecturer.lecturer4.androidos.listener.OnActionListener;
import com.lecturer.lecturer4.androidos.model.User;

import java.util.List;

/**
 * Created by ASUS on 5/22/2018.
 */

public class UserViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;
    private final LiveData<List<User>> liveLiUser;

    public UserViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        liveLiUser = appDatabase.userDao().loadLiveUser();
    }

    public LiveData<List<User>> getLiveLiUser() {
        return liveLiUser;
    }

    public void getLiUserViewModel(OnActionListener oal){
        new AsyncTaskUtils(new AsyncTaskUtils.OnStartProcessParam() {
            @Override
            public void onProcess(Object param) {
                oal.onOk(appDatabase.userDao().loadUser());
            }}).execute((Object[]) null);
    }

    public void addUser(User user) {
        new AsyncTaskUtils(new AsyncTaskUtils.OnStartProcessParam() {
            @Override
            public void onProcess(Object param) {
                appDatabase.userDao().insert(user);
            }}).execute((Object[]) null);
    }

    public void getUser(User user, CallbackCheckPassword callbackCheckPassword) {
        new AsyncTaskUtils(new AsyncTaskUtils.OnStartProcessParam() {
            @Override
            public void onProcess(Object param) {
                appDatabase.userDao().oneUser(user.getUser_id());
                if(appDatabase.userDao().oneUser(user.getUser_id()) == null){
                    Log.d("ASYNC", "onProcess: no such user");
                }else {
                    callbackCheckPassword.checkPassword(appDatabase.userDao().oneUser(user.getUser_id()).getUser_password());
                }
            }}).execute((Object[]) null);
    }

    public void deleteUser(User user){
        new AsyncTaskUtils(new AsyncTaskUtils.OnStartProcessParam() {
            @Override
            public void onProcess(Object param) {
                appDatabase.userDao().deleteUsers(user);
            }
        }).execute((Object[]) null);
    }

    public void updateUser(User user){
        new AsyncTaskUtils(new AsyncTaskUtils.OnStartProcessParam() {
            @Override
            public void onProcess(Object param) {
                Log.d("UPDATE", "onProcess: "+user);
                appDatabase.userDao().updateUsers(user);
            }
        }).execute((Object[]) null);
    }
}
