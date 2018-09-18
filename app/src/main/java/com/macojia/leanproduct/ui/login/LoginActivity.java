package com.macojia.leanproduct.ui.login;

import android.app.LauncherActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.MainActivity;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LC on 2018/8/4.
 */

public class LoginActivity extends BaseActivity {
    @Bind(R.id.bt_go)
    Button mBtGo;
    @Bind(R.id.et_username)
    EditText mEditUsrName;
    @Bind(R.id.et_password)
    EditText mEditPwd;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mEditUsrName.setText("Admin");
        mEditPwd.setText("password_123");
    }

    @OnClick(R.id.bt_go)
    public void GoMain() {
        isValidLogin();
      /*  if (isValidLogin()) {
//        Explode explode = new Explode();
//        explode.setDuration(500);
//
//        getWindow().setExitTransition(explode);
//        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
            Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i2*//*, oc2.toBundle()*//*);
            finish();
        }*/
    }

    private void isValidLogin() {
        String inputUsrName = mEditUsrName.getText().toString();
        String inputPwd = mEditPwd.getText().toString();
        retrofit2.Call<Boolean> call = NetworkManager.getDefault(0).login(inputUsrName, inputPwd);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response != null && response.body() != null && response.body().booleanValue()){
                    Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i2/*, oc2.toBundle()*/);
                    finish();
                }else {
                    Toast.makeText(AppApplication.getInstance(), "用户名或密码错误", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(AppApplication.getInstance(), "用户名或密码错误", Toast.LENGTH_LONG);
            }
        });
        call.request();
    }
}
