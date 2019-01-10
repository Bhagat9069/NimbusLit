package com.nimbuslit.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nimbuslit.Adapter.CreateGroupAdapter;
import com.nimbuslit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateGroup extends Fragment {


    @BindView(R.id.create_group_device_list)
    ListView createGroupDeviceList;
    Unbinder unbinder;
    Activity  activity;
    CreateGroupAdapter createGroupAdapter;

    public CreateGroup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_group, container, false);
        unbinder = ButterKnife.bind(this, view);
        activity=getActivity();
        createGroupAdapter=new CreateGroupAdapter(activity);
        createGroupDeviceList.setAdapter(createGroupAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
