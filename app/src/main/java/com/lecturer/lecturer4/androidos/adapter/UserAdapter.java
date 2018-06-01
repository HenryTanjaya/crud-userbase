package com.lecturer.lecturer4.androidos.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lecturer.lecturer4.androidos.R;
import com.lecturer.lecturer4.androidos.model.User;
import com.lecturer.lecturer4.androidos.viewmodel.UserViewModel;

import java.util.List;

/**
 * Created by IT on 4/16/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> appList;
    private static ClickListener clickListener;
    UserViewModel viewModel;

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_ms_adapter, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User o = appList.get(position);
        holder.appId.setText(o.getUser_id());
        holder.appName.setText(o.getUser_name());
        holder.appLinkName.setText(o.getUser_password());

        if(position%2==1) {
            holder.itemView.setBackgroundResource(R.drawable.list_item_odd);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.list_item_even);
        }
    }

    @Override
    public int getItemCount() {
        return appList != null ? appList.size() : 0;
    }

    public User getItem(int position){
        return appList.get(position);
    }

    public void setList(List<User> appList){
        this.appList = appList;
    }

    public void setOnItemClickListener(ClickListener cl){
        this.clickListener = cl;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

    static class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView appId, appName, appLinkName;

        public UserViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            appId = v.findViewById(R.id.li_ms_application_id);
            appName = v.findViewById(R.id.li_ms_application_app_name);
            appLinkName = v.findViewById(R.id.li_ms_application_app_link_name);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return true;
        }
    }
}