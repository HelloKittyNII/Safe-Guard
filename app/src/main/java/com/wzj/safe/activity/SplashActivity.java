package com.wzj.safe.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.wzj.safe.R;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        initUI();
    }

    private void initUI()
    {
        TextView versionNameTextView = (TextView) findViewById(R.id.versionNameTextView);

        if(versionNameTextView == null)
        {
            return;
        }

        PackageManager packageManager = getPackageManager();
        try
        {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            versionNameTextView.setText(packageInfo.versionName);
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
