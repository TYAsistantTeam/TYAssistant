package com.gzmantis.tyassistant;

import android.os.Bundle;


import com.gzmantis.tyassistant.activities.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}