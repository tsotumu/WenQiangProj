package com.macojia.leanproduct.ui.control.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.macojia.common.base.BaseActivity;
import com.macojia.common.commonutils.LogUtils;
import com.macojia.leanproduct.R;
import com.macojia.leanproduct.ui.MainActivity;
import com.macojia.leanproduct.ui.control.adapter.ProductBrandConstants;
import com.macojia.leanproduct.ui.control.model.ProductBrandModel;

import java.util.HashMap;

import butterknife.Bind;

import static com.macojia.leanproduct.ui.control.adapter.ProductBrandConstants.Brand_NJ;

/**
 * Created by MacoJia on 2018/5/21.
 */

public class QualityFeedBackActivity extends  BaseActivity {
    static final String Brand_NJ = "南京", Brand_TS = "泰山", Brand_BS = "白沙";
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
    public void onBackPressed() {
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2/*, oc2.toBundle()*/);
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String  editNumberInfo = editNumber.getText().toString().trim().toUpperCase();
                    if(editNumberInfo !=null || !editNumberInfo.equals("")){
                        //Toast.makeText(QualityFeedBackActivity.this,editNumberInfo,Toast.LENGTH_LONG).show();
                        ShowStealNumRes(editNumberInfo);
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
    public void ShowStealNumRes(String numberInfo){
        String result = null;
        ProductBrandModel brand = SearchBrand(numberInfo);
        String brandName = getBrandName(numberInfo);
        ProductBrandConstants pbc = new ProductBrandConstants();
        HashMap<String, String> map = (HashMap<String, String>) pbc
                .getNameMap(numberInfo.length());
        String info = "钢印号输入错误，请重新输入!";
        if (brand != null && map != null) {
            String year = null,month=null,day=null;
            if(brandName.equals(Brand_BS)){
                year = brand.getYear();
                month = brand.getMonth();
                day = brand.getDay();
            }else{
                year = map.get(brand.getYear());
                month = map.get(brand.getMonth());
                day = brand.getDay();
            }
            String classes = map.get(brand.getClasses());
            String machine = map.get(brand.getMachineNum());
           // Toast.makeText(this,"year:"+year+",month:"+month+",day:"+day+"classes:"+classes+",machine:"+machine,Toast.LENGTH_LONG).show();
            if (year != null && month != null && day != null && classes != null
                    && machine != null) {
                info = "产品信息：" + year + "年" + month + "月" + day
                        + "日"  + classes  + machine + "号设备生产！";
                Toast toast=Toast.makeText(this,null , Toast.LENGTH_LONG);
                toast.setText(info);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            } else {
                Toast toast= Toast.makeText(this, null, Toast.LENGTH_LONG);
                toast.setText(info);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        } else {
            Toast toast= Toast.makeText(this, null, Toast.LENGTH_LONG);
            toast.setText(info);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }
    public static String SegString(String str, int begin, int end) {
        String segString = str.substring(begin - 1, end - 1);
        return segString;
    }

    public  String getBrandName(String str) {
        int i = str.length();
        if (i == 6) {
            return Brand_NJ;
        }
        if (i == 7) {
            return Brand_TS;
        }
        if (i == 8) {
            return Brand_BS;
        }
        return "0";
    }

    public ProductBrandModel SearchBrand(String steelNum) {
        ProductBrandModel brand = new ProductBrandModel();
        String brandName = getBrandName(steelNum);
        if (brandName.equals(Brand_NJ)) {
            brand.setYear("Y" + SegString(steelNum, 1, 2));
            brand.setMonth("M" + SegString(steelNum, 2, 3));
            brand.setDay(SegString(steelNum, 3, 5));
            brand.setClasses("C" + SegString(steelNum, 5, 6));
            brand.setMachineNum("MA" + SegString(steelNum, 6, 7));
            return brand;
        }
        if (brandName.equals(Brand_TS)) {
            brand.setClasses("C" + SegString(steelNum, 1, 2));
            brand.setMachineNum("MA" + SegString(steelNum, 2, 3));
            brand.setYear("Y" + SegString(steelNum, 3, 4));
            brand.setMonth("M" + SegString(steelNum, 4, 5));
            brand.setDay(SegString(steelNum, 5, 7));
            return brand;
        }
        if (brandName.equals(Brand_BS)) {
            brand.setYear("2015");
            brand.setMonth(SegString(steelNum, 1, 3));
            brand.setDay(SegString(steelNum, 3, 5));
            brand.setMachineNum("MA" + SegString(steelNum, 6, 8));
            brand.setClasses("C" + SegString(steelNum, 8, 9));
            return brand;
        }
        return null;
    }
}
