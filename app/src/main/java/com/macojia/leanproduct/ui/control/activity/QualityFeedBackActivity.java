package com.macojia.leanproduct.ui.control.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.macojia.common.base.BaseActivity;
import com.macojia.leanproduct.R;

import butterknife.Bind;

/**
 * Created by MacoJia on 2018/5/21.
 */

public class QualityFeedBackActivity extends  BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.control_number_feedback)
    EditText editNumber;
    @Bind(R.id.control_search_feedback)
    Button searchButton;
    @Override
    public int getLayoutId() {
        return R.layout.activity_quality_feedback;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String  editNumberInfo = editNumber.getText().toString();
        searchButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(editNumberInfo !=null || !editNumberInfo.equals("")){

                    }
                }
            });
    }

    @Override
    public void initView() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });
    }
}
