package com.gzmantis.tyassistant.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;

public class CommentProgressDialog
{
  private static ProgressDialog progressDialog;
  
  public static void hideProgressDialog()
  {
    if (progressDialog != null) {
      progressDialog.dismiss();
    }
  }
  
  public static void showProgressDialog(Context paramContext)
  {
    progressDialog = ProgressDialog.show(paramContext, paramContext.getResources().getString(2131230774), "正在加载数据......");
    progressDialog.setCanceledOnTouchOutside(true);
    progressDialog.show();
  }
}



/* Location:           C:\Users\Joesea Lea\Desktop\ty_app_dex2jar.jar

 * Qualified Name:     com.tt.caipiao.pkg.utils.CommentProgressDialog

 * JD-Core Version:    0.7.0.1

 */