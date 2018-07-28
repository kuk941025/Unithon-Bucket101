package com.example.jkpark.bucketlist_unit.DTO;

public class LoginDTO {
    private String userName;
    private String nickname;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userEmail) {
        this.userName = userEmail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String niciName) {
        this.nickname = niciName;
    }
}
