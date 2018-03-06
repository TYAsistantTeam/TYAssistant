package com.gzmantis.tyassistant.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LONG on 2018/3/5.
 */

public class SubmitModel implements Serializable {

    private String bonus;
    private int chiocetype;
    private boolean isds;
    private List<String> lotterycontent;
    private List<List<String>> lotterycontents;
    private int lotteryid;
    private String lotteryname;
    private List<String> lotteryweizhis;
    private String model;
    private String multiple;
    private String nums;
    private int playid;
    private String playname;
    private String showlotterycontent;
    private String zhu;
    private String zhumoney;

    public String getBonus() {
        return this.bonus;
    }

    public int getChiocetype() {
        return this.chiocetype;
    }

    public List<String> getLotterycontent() {
        return this.lotterycontent;
    }

    public List<List<String>> getLotterycontents() {
        return this.lotterycontents;
    }

    public int getLotteryid() {
        return this.lotteryid;
    }

    public String getLotteryname() {
        return this.lotteryname;
    }

    public List<String> getLotteryweizhis() {
        return this.lotteryweizhis;
    }

    public String getModel() {
        return this.model;
    }

    public String getMultiple() {
        return this.multiple;
    }

    public String getNums() {
        return this.nums;
    }

    public int getPlayid() {
        return this.playid;
    }

    public String getPlayname() {
        return this.playname;
    }

    public String getShowlotterycontent() {
        return this.showlotterycontent;
    }

    public String getZhu() {
        return this.zhu;
    }

    public String getZhumoney() {
        return this.zhumoney;
    }

    public boolean isds() {
        return this.isds;
    }

    public void setBonus(String paramString) {
        this.bonus = paramString;
    }

    public void setChiocetype(int paramInt) {
        this.chiocetype = paramInt;
    }

    public void setIsds(boolean paramBoolean) {
        this.isds = paramBoolean;
    }

    public void setLotterycontent(List<String> paramList) {
        this.lotterycontent = paramList;
    }

    public void setLotterycontents(List<List<String>> paramList) {
        this.lotterycontents = paramList;
    }

    public void setLotteryid(int paramInt) {
        this.lotteryid = paramInt;
    }

    public void setLotteryname(String paramString) {
        this.lotteryname = paramString;
    }

    public void setLotteryweizhis(List<String> paramList) {
        this.lotteryweizhis = paramList;
    }

    public void setModel(String paramString) {
        this.model = paramString;
    }

    public void setMultiple(String paramString) {
        this.multiple = paramString;
    }

    public void setNums(String paramString) {
        this.nums = paramString;
    }

    public void setPlayid(int paramInt) {
        this.playid = paramInt;
    }

    public void setPlayname(String paramString) {
        this.playname = paramString;
    }

    public void setShowlotterycontent(String paramString) {
        this.showlotterycontent = paramString;
    }

    public void setZhu(String paramString) {
        this.zhu = paramString;
    }

    public void setZhumoney(String paramString) {
        this.zhumoney = paramString;
    }
}
