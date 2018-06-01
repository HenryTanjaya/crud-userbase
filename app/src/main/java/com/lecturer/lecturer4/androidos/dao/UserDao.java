package com.lecturer.lecturer4.androidos.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.lecturer.lecturer4.androidos.model.User;

import java.util.List;

/**
 * Created by ASUS on 5/22/2018.
 */
@Dao
public interface UserDao {
    @Query("select * from user")
    LiveData<List<User>> loadLiveUser();

    @Query("select * from user")
    List<User> loadUser();

    @Query("select * from user where user_id = :id")
    User oneUser(String id);

    @Delete
    public void deleteUsers(User... users);

    @Update
    public void updateUsers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> o);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User o);
}
