package com.gzmantis.tyassistant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gzmantis.tyassistant.R;
import com.gzmantis.tyassistant.activities.personalactivitys.LoginActivity;

public class WelcomeActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayout() {
        return 0;
    }

    @Override
    public int initLayoutTitle() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }
}
