package com.raychal.simpleapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String username;
    private String name;
    private String avatar;
    private String nim;
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

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
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

    public UserModel(String username, String name, String avatar, String nim, String alamat, String hobi, String program_studi, String universitas) {
        this.username = username;
        this.name = name;
        this.avatar = avatar;
        this.nim = nim;
        this.alamat = alamat;
        this.hobi = hobi;
        this.program_studi = program_studi;
        this.universitas = universitas;
    }

    protected UserModel(Parcel in) {
        username = in.readString();
        name = in.readString();
        avatar = in.readString();
        nim = in.readString();
        alamat = in.readString();
        hobi = in.readString();
        program_studi = in.readString();
        universitas = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(avatar);
        dest.writeString(nim);
        dest.writeString(alamat);
        dest.writeString(hobi);
        dest.writeString(program_studi);
        dest.writeString(universitas);
    }
}
