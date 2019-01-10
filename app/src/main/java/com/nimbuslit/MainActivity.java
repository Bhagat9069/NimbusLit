package com.nimbuslit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.nimbuslit.Constant.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;
    private TextView mTextMessage;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*    if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.logo);
            setTitle("NimbusLit");
        }*/
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mainToolbar);
        setTitle("");
//
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @OnClick({R.id.my_network_layout, R.id.smart_device_layout, R.id.dashboard_layout, R.id.group_layout, R.id.demo_layout})
    public void onViewClicked(View view) {

        Intent intent = new Intent(this, HelperActivity.class);
        switch (view.getId()) {
            case R.id.my_network_layout:
                intent.putExtra(Constants.MAIN_KEY, Constants.MY_NETWORK_CODE);
                break;
            case R.id.smart_device_layout:
                intent.putExtra(Constants.MAIN_KEY, Constants.SMART_DEVICE_CODE);
                break;
            case R.id.dashboard_layout:
                intent.putExtra(Constants.MAIN_KEY, Constants.DASHBOARD_CODE);
                break;
            case R.id.group_layout:
                intent.putExtra(Constants.MAIN_KEY, Constants.GROUP_CODE);
                break;
            case R.id.demo_layout:
                intent.putExtra(Constants.MAIN_KEY, Constants.DEMO_CODE);
                break;
        }
        startActivity(intent);
    }
}
