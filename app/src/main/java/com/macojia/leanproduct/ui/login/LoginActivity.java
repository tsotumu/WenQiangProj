package com.macojia.leanproduct.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.widget.Button;
import android.widget.EditText;

import com.macojia.leanproduct.R;
import com.macojia.leanproduct.ui.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LC on 2018/8/4.
 */

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.bt_go)
    Button mBtGo;
    @Bind(R.id.et_username)
    EditText mEditUsrName;
    @Bind(R.id.et_password)
    EditText mEditPwd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        ButterKnife.bind(this);
    }

    private void initView() {

    }

    @OnClick(R.id.bt_go)
    public void GoMain(){
        Explode explode = new Explode();
        explode.setDuration(500);

        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);
        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
        Intent i2 = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i2, oc2.toBundle());
        finish();
    }
}
