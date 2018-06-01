package com.lecturer.lecturer4.androidos.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by ASUS on 5/22/2018.
 */
@Entity(tableName = "user")
public class User {

    private static final long serialVersionUID = 1L;
    @PrimaryKey
    @NonNull
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("user_name")
    private String user_name;
    @SerializedName("user_password")
    private String user_password;
    @SerializedName("inputBy")
    private String inputBy;
    @SerializedName("inputDt")
    private Date inputDt;
    @SerializedName("updateBy")
    private String updateBy;
    @SerializedName("updateDt")
    private Date updateDt;

    public User(){

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getInputBy() {
        return inputBy;
    }

    public void setInputBy(String inputBy) {
        this.inputBy = inputBy;
    }

    public Date getInputDt() {
        return inputDt;
    }

    public void setInputDt(Date inputDt) {
        this.inputDt = inputDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}
