package com.gzmantis.tyassistant.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gzmantis.tyassistant.apis.ByApiDatas;
import com.gzmantis.tyassistant.apis.UserInfo;
import com.gzmantis.tyassistant.customs.ShapeLoadingDialog;
import com.gzmantis.tyassistant.utils.StringUtil;
import com.gzmantis.tyassistant.utils.ToastUtil;

import cn.pedant.SweetAlert.SweetAlertDialog;

public abstract class BasicActivity extends Activity implements View.OnClickListener{

    public ByApiDatas byApiDatas;
    public Gson gson;
    private LinearLayout ll_back;
    private SweetAlertDialog mLoadingDialog;
    private ShapeLoadingDialog mshapeLoadingDialog;
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


    public void IntentActivity(Class paramClass, Bundle paramBundle) {
        Intent localIntent = new Intent(this, paramClass);
        if (paramBundle != null) {
            localIntent.putExtras(paramBundle);
        }

        startActivity(localIntent);
    }

    public void ShowShapLoadingDialog() {
        if (this.mshapeLoadingDialog == null) {
            this.mshapeLoadingDialog = new ShapeLoadingDialog(this);
            this.mshapeLoadingDialog.setCanceledOnTouchOutside(true);
        }
        this.mshapeLoadingDialog.setLoadingText("数据加载中...");
        this.mshapeLoadingDialog.show();
    }

    public String getStringView(EditText paramEditText) {
        String str = "";
        if (paramEditText != null) {
            str = paramEditText.getText().toString().trim();
        }

        return str;
    }

    public abstract void initData();

    public abstract int initLayout();

    public abstract int initLayoutTitle();

    public abstract void initView();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void setActionBarEnable(boolean paramBoolean) {
        if (paramBoolean) {
            getActionBar().show();
        } else {
            getActionBar().hide();
        }
    }

    protected void setBackListener(View.OnClickListener paramOnClickListener) {
        this.ll_back.setOnClickListener(paramOnClickListener);
    }

    public abstract void setListener();

    protected void setTitleName(int paramInt) {
        this.titlename.setText(getResources().getString(paramInt));
    }

    protected void setTitleName(String paramString) {
        this.titlename.setText(paramString);
    }

    protected void showToast(String paramString) {
        if (!StringUtil.isEmpty(paramString)) {
            ToastUtil.showToast(this, paramString);
        }
    }

}
