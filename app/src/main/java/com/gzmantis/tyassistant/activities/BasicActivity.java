package com.gzmantis.tyassistant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gzmantis.tyassistant.apis.ByApiDatas;
import com.gzmantis.tyassistant.apis.UserInfo;

import cn.pedant.SweetAlert.SweetAlertDialog;

public abstract class BasicActivity extends AppCompatActivity implements View.OnClickListener{

    public ByApiDatas byApiDatas;
    public Gson gson;
    private LinearLayout ll_back;
    private SweetAlertDialog mLoadingDialog;
//    private ShapeLoadingDialog mshapeLoadingDialog;
//    private CommonProgressDialog progressDialog;
    private TextView titlename;
//    protected TouchBackFinishLayout touchbackfinish;
    public UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        initView();
//        setListener();
//        initData();
    }

    public abstract void initView();

    public abstract void setListener();

    public abstract void initData();

    public void IntentActivity(Class paramClass, Bundle paramBundle) {
        Intent localIntent = new Intent(this, paramClass);
        if (paramBundle != null) {
            localIntent.putExtras(paramBundle);
        }

        startActivity(localIntent);
    }
}
