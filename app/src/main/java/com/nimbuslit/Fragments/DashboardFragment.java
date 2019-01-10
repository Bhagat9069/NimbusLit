package com.nimbuslit.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.nimbuslit.Adapter.DashoardItemAdapter;
import com.nimbuslit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    @BindView(R.id.dashboard_home_setting_layout)
    LinearLayout dashboardHomeSettingLayout;
    @BindView(R.id.dashboard_spinner)
    Spinner dashboardSpinner;
    @BindView(R.id.dashboarg_item_list)
    ListView dashboargItemList;
    Unbinder unbinder;
    DashoardItemAdapter dashoardItemAdapter;
    Activity activity;
    ArrayAdapter<CharSequence> adapter;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        unbinder = ButterKnife.bind(this, view);
        activity=getActivity();
        if (activity==null)
            return view;
        dashoardItemAdapter=new DashoardItemAdapter(activity);
        adapter = ArrayAdapter.createFromResource(activity,
                R.array.dashboard_spinner, R.layout.spinerlayout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dashboargItemList.setAdapter(dashoardItemAdapter);
        dashboardSpinner.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.dashboard_home_setting_layout)
    public void onViewClicked() {
    }
}
