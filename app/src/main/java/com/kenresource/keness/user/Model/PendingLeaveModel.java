package com.kenresource.keness.user.Model;

/**
 * Created by suchismita on 3/2/2017.
 */

public class PendingLeaveModel {

    String appId,leaveType, date, no_leave , date_applied, date_approved ;


    public PendingLeaveModel()
    {

    }

    public PendingLeaveModel(String appId, String leaveType, String date, String leaveNo ,  String dateApplied, String dateApproved)
    {
        this.appId=appId;
        this.leaveType=leaveType;
        this.date=date;
        this.no_leave=leaveNo;
        this.date_applied=dateApplied;
        this.date_approved = dateApproved;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String  getNo_leave() {
        return no_leave;
    }

    public void setNo_leave(String no_leave) {
        this.no_leave = no_leave;
    }

    public String getDate_applied() {
        return date_applied;
    }

    public void setDate_applied(String date_applied) {
        this.date_applied = date_applied;
    }

    public String getDate_approved() {
        return date_approved;
    }

    public void setDate_approved(String date_approved) {
        this.date_approved = date_approved;
    }
}


