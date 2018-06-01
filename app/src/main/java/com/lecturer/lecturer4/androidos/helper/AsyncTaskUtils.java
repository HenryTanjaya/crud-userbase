package com.lecturer.lecturer4.androidos.helper;

import android.os.AsyncTask;

/**
 * Created by IT on 4/17/2018.
 */

public class AsyncTaskUtils extends AsyncTask<Object, Void, String> {

    private TypeCrudAsyncTask type;
    private OnStartProcess onStartProcess;
    private OnStartProcessParam onStartProcessParam;
    private Object params;

    public AsyncTaskUtils(OnStartProcess onStartProcess) {
        type = TypeCrudAsyncTask.process1;
        this.onStartProcess = onStartProcess;
    }

    public AsyncTaskUtils(OnStartProcessParam onStartProcessParam) {
        type = TypeCrudAsyncTask.process2;
        this.onStartProcessParam = onStartProcessParam;
    }

    @Override
    protected String doInBackground(Object... params) {
        if(type == TypeCrudAsyncTask.process1) {
            onStartProcess.onProcess();
        } else if(type == TypeCrudAsyncTask.process2){
            onStartProcessParam.onProcess(params == null ? null : params[0]);
        }
        return null;
    }


    public interface OnStartProcess{
        void onProcess();
    }

    public interface OnStartProcessParam{
        void onProcess(Object param);
    }
    enum TypeCrudAsyncTask{
        process1,
        process2
    }
}
