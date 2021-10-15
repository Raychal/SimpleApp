package com.raychal.simpleapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String username;
    private String name;
    private String avatar;
    private Integer nim;
    private String alamat;
    private String hobi;
    private String program_studi;
    private String universitas;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getProgram_studi() {
        return program_studi;
    }

    public void setProgram_studi(String program_studi) {
        this.program_studi = program_studi;
    }

    public String getUniversitas() {
        return universitas;
    }

    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }

    public UserModel(String username, String name, String avatar, Integer nim, String alamat, String hobi, String program_studi, String universitas) {
        this.username = username;
        this.name = name;
        this.avatar = avatar;
        this.nim = nim;
        this.alamat = alamat;
        this.hobi = hobi;
        this.program_studi = program_studi;
        this.universitas = universitas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.name);
        dest.writeString(this.avatar);
        dest.writeValue(this.nim);
        dest.writeString(this.alamat);
        dest.writeString(this.hobi);
        dest.writeString(this.program_studi);
        dest.writeString(this.universitas);
    }

    public void readFromParcel(Parcel source) {
        this.username = source.readString();
        this.name = source.readString();
        this.avatar = source.readString();
        this.nim = (Integer) source.readValue(Integer.class.getClassLoader());
        this.alamat = source.readString();
        this.hobi = source.readString();
        this.program_studi = source.readString();
        this.universitas = source.readString();
    }

    protected UserModel(Parcel in) {
        this.username = in.readString();
        this.name = in.readString();
        this.avatar = in.readString();
        this.nim = (Integer) in.readValue(Integer.class.getClassLoader());
        this.alamat = in.readString();
        this.hobi = in.readString();
        this.program_studi = in.readString();
        this.universitas = in.readString();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
