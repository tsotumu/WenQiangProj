package com.macojia.leanproduct.ui.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.http.NetworkManager;
import com.macojia.leanproduct.ui.MainActivity;

import butterknife.Bind;
import butterknife.OnClick;

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
        if (isValidLogin()) {
//        Explode explode = new Explode();
//        explode.setDuration(500);
//
//        getWindow().setExitTransition(explode);
//        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
            Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i2/*, oc2.toBundle()*/);
            finish();
        }
    }

    private boolean isValidLogin() {
        String inputUsrName = mEditUsrName.getText().toString();
        String inputPwd = mEditPwd.getText().toString();
        NetworkManager.getDefault(0).login(inputUsrName, inputPwd);
        return true;
    }
}
