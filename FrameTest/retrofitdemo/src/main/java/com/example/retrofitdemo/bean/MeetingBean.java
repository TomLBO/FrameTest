package com.example.retrofitdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bob on 2016/3/24.
 */
public class MeetingBean implements Serializable {
    private String Id;//会议编号
    private String Name;//会议名称
    private String OUName;//主办方
    private String Room;
    private String Content;
    private String Place;//开会地点
    private String Owner;//主持人
    private String Description;//描述
    private String BeginTime;//开始时间
    private String EndTime;//结束时间
    private String SignTime;//可以签到的时间
    private int NeedSign;//0不需要签到，1需要签到
    private int IsBegin;//是否已经开始
    //    private List<FileBean> FileList;//附件集合
//    private List<PersonBean> PersonList;//人员集合
//    private List<VoteBean> VoteList;//投票集合
    private int viewColor;//日历显示背景颜色

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOUName() {
        return OUName;
    }

    public void setOUName(String OUName) {
        this.OUName = OUName;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(String beginTime) {
        BeginTime = beginTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getSignTime() {
        return SignTime;
    }

    public void setSignTime(String signTime) {
        SignTime = signTime;
    }

    public int getNeedSign() {
        return NeedSign;
    }

    public void setNeedSign(int needSign) {
        NeedSign = needSign;
    }

    public int getIsBegin() {
        return IsBegin;
    }

    public void setIsBegin(int isBegin) {
        IsBegin = isBegin;
    }

    public int getViewColor() {
        return viewColor;
    }

    public void setViewColor(int viewColor) {
        this.viewColor = viewColor;
    }

    @Override
    public String toString() {
        return "MeetingBean{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", OUName='" + OUName + '\'' +
                ", Room='" + Room + '\'' +
                ", Content='" + Content + '\'' +
                ", Place='" + Place + '\'' +
                ", Owner='" + Owner + '\'' +
                ", Description='" + Description + '\'' +
                ", BeginTime='" + BeginTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", SignTime='" + SignTime + '\'' +
                ", NeedSign=" + NeedSign +
                ", IsBegin=" + IsBegin +
                '}';
    }
}
