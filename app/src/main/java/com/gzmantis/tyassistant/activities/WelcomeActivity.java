package com.gzmantis.tyassistant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
}
