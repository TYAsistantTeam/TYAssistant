package com.gzmantis.tyassistant.apis;

import android.content.Context;

import com.gzmantis.tyassistant.utils.ShareUtils;
import com.gzmantis.tyassistant.utils.StringUtil;

/**
 * Created by LONG on 2018/3/5.
 */

public class UserInfo {

    private static Boolean AutoVersion = true;
    private static long CutTimeLogin = System.currentTimeMillis();
    private static String currentIssueno;
    private static String lottery;
    private static String lotteryid;
    private static String lotteryplayid;
    private static String lotteryplayname;
    private static String usepwd;
    private static String usercode;
    private static String username = "";
    private String AutoVersionkey = "AutoVersion";
    private String CutTimeLoginkey = "CutTimeLogin";
    private String EnableScores = "0";
    private String EnableScoreskey = "EnableScores";
    private boolean HasFundsPwd = false;
    private String HasFundsPwdkey = "HasFundsPwd";
    private String Rebate = "0";
    private String Rebatekey = "Rebate";
    private String codekey = "usercode";
    private Context context;
    private String currentIssuenokey = "currentIssueno";
    private String lotteryidkey = "lotteryid";
    private String lotterykey = "lottery";
    private String lotteryplayidkey = "lotteryplayid";
    private String lotteryplaynamekey = "lotteryplayname";
    private String useraccountkey = "useraccount";
    private String userpasswordkey = "userpassword";
    private String webstateurlkey = "webstateurl";

    public UserInfo(Context paramContext) {
        this.context = paramContext;
    }

    public String getWebstate() {
        String str = (String) ShareUtils.getParam(this.context, this.webstateurlkey, "");
        if (!StringUtil.isEmpty(str)) {
            Config.HOST = str;
        }

        return Config.HOST;
    }
}
