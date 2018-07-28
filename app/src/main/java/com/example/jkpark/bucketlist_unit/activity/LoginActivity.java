package com.example.jkpark.bucketlist_unit.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.jkpark.bucketlist_unit.DTO.LoginDTO;
import com.example.jkpark.bucketlist_unit.MainActivity;
import com.example.jkpark.bucketlist_unit.R;
import com.example.jkpark.bucketlist_unit.Repo.Login.RepoLogin;
import com.example.jkpark.bucketlist_unit.global.GlobalVar;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "OAuthSampleActivity";

    private GlobalVar global;

    /**
     * client 정보를 넣어준다.
     */
    private static String OAUTH_CLIENT_ID = "tno75hbvX6MSfQ92zm7N";
    private static String OAUTH_CLIENT_SECRET = "ZR9kPAMrVB";
    private static String OAUTH_CLIENT_NAME = "네이버 아이디로 로그인 테스트";

    private static OAuthLogin mOAuthLoginInstance;
    private static Context mContext;

    /**
     * UI 요소들
     */

    private OAuthLoginButton mOAuthLoginButton;

    Retrofit loginRetrofit;
    RepoLogin.ApiService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        global = (GlobalVar) getApplicationContext();

        loginRetrofit = new Retrofit.Builder().baseUrl(RepoLogin.ApiService.API_URL_AUTH)
                .addConverterFactory(GsonConverterFactory.create()).build();
        loginService = loginRetrofit.create(RepoLogin.ApiService.class);

        initData();
        initView();
    }

    private void initData() {
        mOAuthLoginInstance = OAuthLogin.getInstance();

        mOAuthLoginInstance.showDevelopersLog(true);
        mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);

        /*
         * 2015년 8월 이전에 등록하고 앱 정보 갱신을 안한 경우 기존에 설정해준 callback intent url 을 넣어줘야 로그인하는데 문제가 안생긴다.
         * 2015년 8월 이후에 등록했거나 그 뒤에 앱 정보 갱신을 하면서 package name 을 넣어준 경우 callback intent url 을 생략해도 된다.
         */
        //mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_callback_intent_url);
    }

    private void initView() {

        mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

//        updateView();
    }


    private void updateView() {
//        mOAuthState.setText(mOAuthLoginInstance.getState(mContext).toString());
    }

    @Override
    protected void onResume() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onResume();

    }

    /**
     * startOAuthLoginActivity() 호출시 인자로 넘기거나, OAuthLoginButton 에 등록해주면 인증이 종료되는 걸 알 수 있다.
     */
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                //혹시 몰라 남겨 둔 어세스 토큰
                Log.d("accessToken", accessToken);

                new RequestApiTask().execute();

            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }

    };


    //로그아웃 기능을 만들 지 몰라 남겨 둔 기능
    private class DeleteTokenTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            boolean isSuccessDeleteToken = mOAuthLoginInstance.logoutAndDeleteToken(mContext);

            if (!isSuccessDeleteToken) {
                // 서버에서 token 삭제에 실패했어도 클라이언트에 있는 token 은 삭제되어 로그아웃된 상태이다
                // 실패했어도 클라이언트 상에 token 정보가 없기 때문에 추가적으로 해줄 수 있는 것은 없음
                Log.d(TAG, "errorCode:" + mOAuthLoginInstance.getLastErrorCode(mContext));
                Log.d(TAG, "errorDesc:" + mOAuthLoginInstance.getLastErrorDesc(mContext));
            }

            return null;
        }

        protected void onPostExecute(Void v) {
            updateView();
        }
    }

    //네아로 로그인 후 정보를 가져올 때 사용
    private class RequestApiTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(Void... params) {
            String url = "https://openapi.naver.com/v1/nid/me";
            String at = mOAuthLoginInstance.getAccessToken(mContext);
            return mOAuthLoginInstance.requestApi(mContext, at, url);
        }

        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONObject response = jsonObject.getJSONObject("response");

                global.userName = response.getString("name");
                global.nickName = response.getString("name");

                LoginDTO loginDTO = new LoginDTO();
                loginDTO.setUserName(global.userName);
                loginDTO.setNickname(global.nickName);

                Call<RepoLogin> login = loginService.put_Login("application/json", loginDTO);
                login.enqueue(new Callback<RepoLogin>() {
                    @Override
                    public void onResponse(Call<RepoLogin> call, Response<RepoLogin> response) {
                        if(response.isSuccessful()){
                            Log.d("test", response.body().getResult());
                            Intent mirror = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(mirror);
                        }else{
                            Log.d("fail1", call.request().method().toString());
                            Log.d("fail2", call.request().body().toString());
                            Log.d("fail3", call.request().toString());
                            Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RepoLogin> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    }
                });


            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //토큰 갱신 할 때 사용, 혹시 몰라 남겨둡시다.
    private class RefreshTokenTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            return mOAuthLoginInstance.refreshAccessToken(mContext);
        }

        protected void onPostExecute(String res) {
            updateView();
        }
    }

}
