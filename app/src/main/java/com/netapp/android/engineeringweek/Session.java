package com.netapp.android.engineeringweek;

/**
 * Created by Samin on 09/05/2018.
 */

public class Session {
    private String id;
    private String time;
    private String sessionName;
    private String speakers;
    private String userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "{" + id + "::" + time + "::" + sessionName + "::" + speakers + "::" + userType + "}";
    }
}
