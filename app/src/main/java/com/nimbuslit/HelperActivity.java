package com.nimbuslit;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.nimbuslit.Constant.Constants;
import com.nimbuslit.Fragments.AddDeviceFragment;
import com.nimbuslit.Fragments.CreateGroup;
import com.nimbuslit.Fragments.DashboardFragment;
import com.nimbuslit.Fragments.EditGroupFragment;
import com.nimbuslit.Fragments.GroupFragment;

public class HelperActivity extends AppCompatActivity {
    Fragment fragment;
    int fragmentLoadCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setContentView(R.layout.activity_helper);

        Intent intent=getIntent();
        if (intent==null)
        {
            finish();
            return;
        }
        if (intent.hasExtra(Constants.MAIN_KEY))
        {
            switch (intent.getIntExtra(Constants.MAIN_KEY,0))
            {
                case Constants.MY_NETWORK_CODE:
                    setTitle("My Network");
                    Toast.makeText(this, "Will be soon", Toast.LENGTH_SHORT).show();
                    break;

                case Constants.SMART_DEVICE_CODE:
                    setTitle("Smart Device");
                    loadFragment(new AddDeviceFragment());
                    break;

                case Constants.DASHBOARD_CODE:
                    setTitle("Dashboard");
                    loadFragment(new DashboardFragment());
                    break;

                case Constants.GROUP_CODE:
                    setTitle("Group");
                    loadFragment(new GroupFragment());
                    break;

                case Constants.EDIT_GROUP:
                    setTitle("Edit Group");
                    loadFragment(new EditGroupFragment());
                    break;
                 case Constants.CREATE_GROUP:
                    setTitle("Create Group");
                    loadFragment(new CreateGroup());
                    break;

                case Constants.DEMO_CODE:
                    Toast.makeText(this, "Will be soon", Toast.LENGTH_SHORT).show();
                    setTitle("Demo");

                    break;



            }
        }
    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStackImmediate();
        }
        else
            finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadFragment(Fragment fragment)
    {
        String backStateName=fragment.getClass().getSimpleName();
        Log.w("LoadFragment",backStateName+" " +fragment.getClass().getName() );
        this.fragment = fragment;
        FragmentManager manager = getSupportFragmentManager();
        if ( manager.findFragmentByTag(backStateName) == null)
        {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frame_layout, fragment,backStateName);
            fragmentTransaction.addToBackStack(backStateName);
            fragmentTransaction.commitAllowingStateLoss();
//            return;
        }
        else
        {
            for (int i = manager.getBackStackEntryCount() - 1; i >=0; i--) {
                Log.w("ClassName",manager.getBackStackEntryAt(i).getName());
                if (!manager.getBackStackEntryAt(i).getName().equalsIgnoreCase(backStateName)) {
                    Log.w("ClassName",manager.getBackStackEntryAt(i).getName());
                    manager.popBackStack();
                } else {
                    manager.popBackStack();
                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
                    fragmentTransaction.replace(R.id.main_frame_layout, fragment, backStateName);
                    fragmentTransaction.addToBackStack(backStateName);
                    fragmentTransaction.commitAllowingStateLoss();
                    break;
                }
//                if (i==0)
            }
        }



    }

}
