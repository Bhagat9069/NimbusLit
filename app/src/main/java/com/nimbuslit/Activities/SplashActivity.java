package com.nimbuslit.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.nimbuslit.MainActivity;
import com.nimbuslit.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        goNext();
    }
    public void goNext()
    {

//        splashVideo.setVisibility(View.GONE);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
           /* if (mediaPlayer != null)
                mediaPlayer.pause();*/


            Intent intent;
                intent = new Intent(this, MainActivity.class);
//                    intent = new Intent(SplashScreen.this, AddressActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

        }, 2000);
    }
}
