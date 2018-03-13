package com.gzmantis.tyassistant.apis;

import android.content.Context;
import com.google.gson.Gson;
import com.gzmantis.tyassistant.https.HttpListener;
import com.gzmantis.tyassistant.https.HttpParam;
import com.gzmantis.tyassistant.https.HttpTask;
import com.gzmantis.tyassistant.utils.Md5;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ByApiDatas
{
  private Context context;
  
  public ByApiDatas(Context paramContext)
  {
    this.context = paramContext;
    Config.HOST = new UserInfo(paramContext).getWebstate();
  }
  
  public static <T> String listToJson(List<T> paramList)
  {
    return new Gson().toJson(paramList);
  }
  
  public static <T> String mapToJson(Map<String, T> paramMap)
  {
    return new Gson().toJson(paramMap);
  }
  
  public void AddBindCard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("password", Md5.getMD51(paramString3));
    localHashMap.put("bankType", paramString4);
    localHashMap.put("owerName", paramString5);
    localHashMap.put("cardNo", paramString6);
    localHashMap.put("fundsPwd", paramString7);
    localHttpParam.setMethod("/ClientMain/AddBindCard");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void AddMember(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("lowerName", paramString3);
    localHashMap.put("nickName", paramString4);
    localHashMap.put("lowerPwd", paramString5);
    localHashMap.put("leaveRebate", paramString6);
    localHttpParam.setMethod("/ClientMain/AddMember");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void BuyRecord(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("password", Md5.getMD51(paramString3));
    localHashMap.put("lotteryId", paramString4);
    localHashMap.put("issueNo", paramString5);
    localHashMap.put("BuyInfo", paramString6);
    localHttpParam.setMethod("/ClientMain/BuyRecord");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void ChangeWebState(HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam("http://dz.dr2b.com:899/getline.ashx", true);
    localHttpParam.setMethod("");
    localHttpParam.setParams(null);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void DrawRecord(String paramString1, String paramString2, String paramString3, String paramString4, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("password", Md5.getMD51(paramString3));
    localHashMap.put("orderId", paramString4);
    localHttpParam.setMethod("/ClientMain/DrawRecord");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetBetRecord(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("orderId", paramString3);
    localHttpParam.setMethod("/ClientMain/GetBetRecord");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetBindCard(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("password", Md5.getMD51(paramString3));
    localHttpParam.setMethod("/ClientMain/GetBindCard");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetCurrentLotteryInfo(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("lotteryId", paramString3);
    localHttpParam.setMethod("/ClientMain/GetCurrentLotteryInfo");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetMoneyChange(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("pageIndex", paramString3);
    localHttpParam.setMethod("/ClientMain/GetMoneyChange");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetMoreLotteryInfo(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("lotteryId", paramString3);
    localHttpParam.setMethod("/ClientMain/GetMoreLotteryInfo");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetQuotaInfo(String paramString1, String paramString2, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHttpParam.setMethod("/ClientMain/GetQuotaInfo");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetRecordList(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("pageIndex", paramString3);
    localHttpParam.setMethod("/ClientMain/GetRecordList");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetReport(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("reportDay", paramString3);
    localHttpParam.setMethod("/ClientMain/GetReport");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetTeamReport(String paramString1, String paramString2, String paramString3, String paramString4, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("start", paramString3);
    localHashMap.put("end", paramString4);
    localHttpParam.setMethod("/ClientMain/GetTeamReport");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GetVersion(HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    localHttpParam.setMethod("/Index/GetVersion");
    localHttpParam.setParams(null);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void GlobalConfig(String paramString1, String paramString2, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHttpParam.setMethod("/ClientMain/GlobalConfig");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void Input(String paramString1, String paramString2, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(false);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHttpParam.setMethod("/ClientMain/Input");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void InputLower(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("lowName", paramString3);
    localHashMap.put("amount", paramString4);
    localHashMap.put("fundsPwd", paramString5);
    localHashMap.put("otpPwd", paramString6);
    localHttpParam.setMethod("/ClientMain/InputLower");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void Kouling(String paramString, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString);
    localHttpParam.setMethod("/Index/CheckdDongTai");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void Login(String userName, String password, String optPwd, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", userName);
    localHashMap.put("password", Md5.getMD51(password));
    localHashMap.put("optPwd", optPwd);
    localHttpParam.setMethod("/Index/ClientLogin");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void Lottery(String paramString1, String paramString2, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHttpParam.setMethod("/ClientMain/GetAllLotteryInfo");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void News(String paramString1, String paramString2, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHttpParam.setMethod("/ClientMain/GetNews");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void SettingFundsPwd(String paramString1, String paramString2, String paramString3, String paramString4, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("newPwd", paramString3);
    localHashMap.put("otpPwd", paramString4);
    localHttpParam.setMethod("/ClientMain/SettingFundsPwd");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void UpFundsPwd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("oldPwd", paramString3);
    localHashMap.put("newPwd", paramString4);
    localHashMap.put("otpPwd", paramString5);
    localHttpParam.setMethod("/ClientMain/UpFundsPwd");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void UpdatePwd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("oldPwd", paramString3);
    localHashMap.put("newPwd", paramString4);
    localHashMap.put("otpPwd", paramString5);
    localHttpParam.setMethod("/ClientMain/UpdatePwd");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void UserInfo(String paramString1, String paramString2, String paramString3, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("password", Md5.getMD51(paramString2));
    localHashMap.put("code", paramString3);
    localHttpParam.setMethod("/ClientMain/GetAccountInfo");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
  
  public void Withdraws(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, HttpListener paramHttpListener)
  {
    HttpParam localHttpParam = new HttpParam(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userName", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("bankId", paramString3);
    localHashMap.put("amount", paramString4);
    localHashMap.put("fundsPwd", paramString5);
    localHashMap.put("otpPwd", paramString6);
    localHttpParam.setMethod("/ClientMain/Withdraws");
    localHttpParam.setParams(localHashMap);
    new HttpTask(this.context, paramHttpListener).execute(new HttpParam[] { localHttpParam });
  }
}
