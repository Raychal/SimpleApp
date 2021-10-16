package com.raychal.simpleapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DiscussionModel implements Parcelable {
    private String title;
    private String subtitle;
    private String avatar;
    private String avatar_content;
    private String content;
    private String history;
    private String reference;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_content() {
        return avatar_content;
    }

    public void setAvatar_content(String avatar_content) {
        this.avatar_content = avatar_content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public DiscussionModel(String title, String subtitle, String avatar, String avatar_content, String content, String history, String reference) {
        this.title = title;
        this.subtitle = subtitle;
        this.avatar = avatar;
        this.avatar_content = avatar_content;
        this.content = content;
        this.history = history;
        this.reference = reference;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.subtitle);
        dest.writeString(this.avatar);
        dest.writeString(this.avatar_content);
        dest.writeString(this.content);
        dest.writeString(this.history);
        dest.writeString(this.reference);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.subtitle = source.readString();
        this.avatar = source.readString();
        this.avatar_content = source.readString();
        this.content = source.readString();
        this.history = source.readString();
        this.reference = source.readString();
    }

    protected DiscussionModel(Parcel in) {
        this.title = in.readString();
        this.subtitle = in.readString();
        this.avatar = in.readString();
        this.avatar_content = in.readString();
        this.content = in.readString();
        this.history = in.readString();
        this.reference = in.readString();
    }

    public static final Parcelable.Creator<DiscussionModel> CREATOR = new Parcelable.Creator<DiscussionModel>() {
        @Override
        public DiscussionModel createFromParcel(Parcel source) {
            return new DiscussionModel(source);
        }

        @Override
        public DiscussionModel[] newArray(int size) {
            return new DiscussionModel[size];
        }
    };
}
