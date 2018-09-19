package com.macojia.leanproduct.ui.login;

import android.content.Intent;
import android.os.MessageQueue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.MainActivity;

import butterknife.Bind;
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
        mEditUsrName.setText("200972");
        mEditPwd.setText("1");
    }

    public void GoMain(View view) {
        isValidLogin();
    }

    private void isValidLogin() {
        String inputUsrName = mEditUsrName.getText().toString();
        String inputPwd = mEditPwd.getText().toString();
        retrofit2.Call<String> call = NetworkManager.getDefault(1).login(inputUsrName, inputPwd);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response != null && response.body() != null) {
                    if (response.body().equals("true")) {
                        LoginActivity.this.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                            @Override
                            public boolean queueIdle() {
                                Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i2/*, oc2.toBundle()*/);
                                LoginActivity.this.finish();
                                return false;
                            }
                        });
                    } else {
                        Toast.makeText(LoginActivity.this, R.string.wrong_usn_pwd, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, R.string.wrong_usn_pwd, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(LoginActivity.this, R.string.wrong_network, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
