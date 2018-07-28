package com.example.jkpark.bucketlist_unit.Repo.Login;

import com.example.jkpark.bucketlist_unit.DTO.LoginDTO;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public class RepoLogin {

    @SerializedName("result")
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String body) {
        this.result = result;
    }

    public interface ApiService {
        public static final String API_URL_AUTH = "http://13.209.8.64:24680/";

        @POST("sign_in")
        Call<RepoLogin> put_Login(@Header("Accept") String Accept, @Body LoginDTO loginDTO) ;

    }
}
