package com.nimbuslit.Fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nimbuslit.Adapter.AddDeviceListAdapter;
import com.nimbuslit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.alterac.blurkit.BlurLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddDeviceFragment extends Fragment {


    @BindView(R.id.device_list)
    ListView deviceList;

    Unbinder unbinder;
    AddDeviceListAdapter addDeviceListAdapter;
    Activity activity;

    ArrayAdapter<CharSequence> adapter;
    int movement=150;

    public AddDeviceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_device, container, false);
        unbinder = ButterKnife.bind(this, view);
        activity=getActivity();
        if (activity==null)
            return view;
        addDeviceListAdapter=new AddDeviceListAdapter(activity);
        deviceList.setAdapter(addDeviceListAdapter);

/*
        blurLayout.animate().translationY(movement).setDuration(1500).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                movement = movement > 0 ? -150 : 150;
                blurLayout.animate().translationY(movement).setDuration(1500).setListener(this).start();
            }
        }).start();
*/
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
