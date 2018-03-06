package com.gzmantis.tyassistant.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.gzmantis.tyassistant.R;
import com.gzmantis.tyassistant.TApplication;
import com.gzmantis.tyassistant.apis.ByApiDatas;
import com.gzmantis.tyassistant.apis.UserInfo;
import com.gzmantis.tyassistant.https.ApiDatas;
import com.gzmantis.tyassistant.utils.ToastUtil;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BasicFragment extends Fragment {

    protected String TAG;
    public ApiDatas apiDatas;
    public ByApiDatas byApiDatas;
    public Gson gson;
    protected TApplication mApp;
    protected View mContentView;
    private SweetAlertDialog mLoadingDialog;
    public UserInfo userInfo;

    public void IntentActivity(Class paramClass, Bundle paramBundle) {
        Intent localIntent = new Intent(getActivity(), paramClass);
        if (paramBundle != null) {
            localIntent.putExtras(paramBundle);
        }
        startActivity(localIntent);
    }

    public void dismissLoadingDialog() {
        if (this.mLoadingDialog == null) {
            return;
        }
        this.mLoadingDialog.dismiss();
    }

    protected abstract void initView(Bundle paramBundle);

    public void onAttach(Activity paramActivity)
    {
        super.onAttach(paramActivity);
        this.TAG = super.getClass().getSimpleName();
        this.mApp = TApplication.getInstance();
        this.gson = new Gson();
        this.byApiDatas = new ByApiDatas(paramActivity);
        this.apiDatas = this.mApp.getEngine();
        this.userInfo = new UserInfo(paramActivity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle paramBundle)
    {
        if (this.mContentView == null)
        {
            initView(paramBundle);
            setListener();
            processLogic(paramBundle);
        }

        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    protected abstract void onUserVisible();

    protected abstract void processLogic(Bundle paramBundle);

    protected abstract void setListener();

    @Override
    public void setUserVisibleHint(boolean paramBoolean) {
        super.setUserVisibleHint(paramBoolean);
        if (!paramBoolean) {
            return;
        }

        onUserVisible();
    }

    public void showLoadingDialog() {
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = new SweetAlertDialog(getActivity(), 5);
            this.mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(0));
            this.mLoadingDialog.setCancelable(false);
            this.mLoadingDialog.setTitleText("数据加载中...");
        }

        this.mLoadingDialog.show();
    }

    protected void showToast(String paramString) {
        ToastUtil.showToast(getActivity(), paramString);
    }
}
