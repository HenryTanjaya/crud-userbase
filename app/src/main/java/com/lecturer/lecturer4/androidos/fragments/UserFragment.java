package com.lecturer.lecturer4.androidos.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lecturer.lecturer4.androidos.R;
import com.lecturer.lecturer4.androidos.aabase.BaseFragment;
import com.lecturer.lecturer4.androidos.activity.AddActivity;
import com.lecturer.lecturer4.androidos.activity.CallbackCheckPassword;
import com.lecturer.lecturer4.androidos.activity.EditDeleteActivity;
import com.lecturer.lecturer4.androidos.activity.FormSoftwareActivity;
import com.lecturer.lecturer4.androidos.adapter.UserAdapter;
import com.lecturer.lecturer4.androidos.listener.OnActionListener;
import com.lecturer.lecturer4.androidos.model.User;
import com.lecturer.lecturer4.androidos.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout srl;
    private UserAdapter adapter;
    private RecyclerView rView;
    private Button nextButton;
    UserViewModel viewModel;

    public static UserFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);

        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragm_ms_application, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        srl = view.findViewById(R.id.activity_main_srl);
        rView = view.findViewById(R.id.li_ms_application);
        rView.setLayoutManager(new LinearLayoutManager(getCtx()));
        rView.setItemAnimator(new DefaultItemAnimator());
        nextButton = view.findViewById(R.id.buttonnew);
        srl.setColorSchemeColors(ContextCompat.getColor(getCtx(), R.color.green), ContextCompat.getColor(getCtx(), R.color.pink), ContextCompat.getColor(getCtx(), R.color.orange));
        srl.setOnRefreshListener( this);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AddActivity.class);
                startActivity(i);
            }
        });

        adapter = new UserAdapter();
        adapter.setOnItemClickListener(new UserAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent i = new Intent(getContext(), EditDeleteActivity.class);
                User o = adapter.getItem(position);
                i.putExtra("id", o.getUser_id());
                i.putExtra("username", o.getUser_name());
                i.putExtra("userpassword", o.getUser_password());
                startActivity(i);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Log.d("onItemLongClick", "onItemLongClick");
            }
        });
        rView.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onRefresh() {
        srl.setRefreshing(true);

        List<User> liData = new ArrayList<User>();

        viewModel = ViewModelProviders.of((FragmentActivity) getCtx()).get(UserViewModel.class);
        viewModel.getLiUserViewModel(new OnActionListener() {
             @Override
             public void onOk(List<User> list) {

                 viewModel = ViewModelProviders.of((FragmentActivity) getCtx()).get(UserViewModel.class);
                 for(int i=0;i<list.size();i++){
                     User o = new User();
                     o.setUser_id(list.get(i).getUser_id());
                     o.setUser_name(list.get(i).getUser_name());
                     o.setUser_password(list.get(i).getUser_password());
                     liData.add(o);
                }

             }
         });

        adapter.setList(liData);
        adapter.notifyDataSetChanged();
        srl.setRefreshing(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}