package com.gzmantis.tyassistant.customs;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by LONG on 2018/3/6.
 */

public class ShapeLoadingDialog
{
    private Context mContext;
    private Dialog mDialog;
    private View mDialogContentView;
    private LoadingView mLoadingView;

    public ShapeLoadingDialog(Context paramContext)
    {
        this.mContext = paramContext;
        init();
    }

    private DisplayMetrics getDensity(Context paramContext)
    {
        return paramContext.getResources().getDisplayMetrics();
    }

    private void init()
    {
//        this.mDialog = new Dialog(this.mContext, 2131296375);
//        this.mDialogContentView = LayoutInflater.from(this.mContext).inflate(2130968646, null);
//        this.mLoadingView = ((LoadingView)this.mDialogContentView.findViewById(2131624236));
//        this.mDialog.setContentView(this.mDialogContentView);
    }

    public void dismiss()
    {
        this.mDialog.dismiss();
    }

    public Dialog getDialog()
    {
        return this.mDialog;
    }

    public void setBackground(int paramInt)
    {
//        ((GradientDrawable)this.mDialogContentView.getBackground()).setColor(paramInt);
    }

    public void setCanceledOnTouchOutside(boolean paramBoolean)
    {
        this.mDialog.setCanceledOnTouchOutside(paramBoolean);
    }

    public void setLoadingText(CharSequence paramCharSequence)
    {
//        this.mLoadingView.setLoadingText(paramCharSequence);
    }

    public void show()
    {
        this.mDialog.show();
    }
}