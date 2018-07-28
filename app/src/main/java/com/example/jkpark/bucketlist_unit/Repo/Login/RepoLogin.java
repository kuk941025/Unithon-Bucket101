package com.example.jkpark.bucketlist_unit.Repo.Login;

import com.example.jkpark.bucketlist_unit.DTO.LoginDTO;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;

public class RepoLogin {

    @SerializedName("message")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public interface ApiService {
        public static final String API_URL_AUTH = "https://kcwv6r78h3.execute-api.ap-northeast-2.amazonaws.com/";

        @PUT("prod/api/login")
        Call<RepoLogin> put_Login(@Header("Accept") String Accept, @Body LoginDTO loginDTO) ;

    }
}
