package com.gzmantis.tyassistant.activities.personalactivitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gzmantis.tyassistant.MainActivity;
import com.gzmantis.tyassistant.R;
import com.gzmantis.tyassistant.activities.BasicActivity;
import com.gzmantis.tyassistant.utils.ActivityUtil;

public class LoginActivity extends BasicActivity {

    private String account = "";
    private ActivityUtil activityUtil;
    private Button btn_login;
    private EditText edit_account;
    private EditText edit_kouling;
    private EditText edit_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setListener();
        initData();
    }

    @Override
    public void initView() {
        this.btn_login = (Button) findViewById(R.id.btn_login);
        this.edit_account = (EditText) findViewById(R.id.edit_account);
        this.edit_password = (EditText) findViewById(R.id.edit_password);
        this.edit_kouling = (EditText) findViewById(R.id.edit_kouling);
    }

    @Override
    public void setListener() {
        this.btn_login.setOnClickListener(this);
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

    private void ToMain() {
        this.activityUtil = new ActivityUtil(this);
        if (!this.activityUtil.isExsitMianActivity(MainActivity.class)) {
            IntentActivity(MainActivity.class, null);
        }

        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == this.btn_login.getId()) {
            ToMain();
        }
    }
}
