package com.it1224.demos.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * demo的信息
 */

public class DemoInfo implements Parcelable {

    private String id;
    private String name;
    private String description;
    private String time;
    private String activity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "DemoInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.time);
        dest.writeString(this.activity);
    }

    public DemoInfo() {
    }

    protected DemoInfo(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.time = in.readString();
        this.activity = in.readString();
    }

    public static final Parcelable.Creator<DemoInfo> CREATOR = new Parcelable.Creator<DemoInfo>() {
        public DemoInfo createFromParcel(Parcel source) {
            return new DemoInfo(source);
        }

        public DemoInfo[] newArray(int size) {
            return new DemoInfo[size];
        }
    };
}
