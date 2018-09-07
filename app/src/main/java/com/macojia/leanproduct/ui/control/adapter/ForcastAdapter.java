package com.macojia.leanproduct.ui.control.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.bean.control.ForcastData;
import com.macojia.leanproduct.chart.ChartItem;

import java.util.ArrayList;
import java.util.List;

public class ForcastAdapter extends ArrayAdapter<Integer> {
    public ForcastAdapter(@NonNull Context context,  @NonNull List<Integer> objects) {
        super(context, 0, objects);
    }

    public static ForcastAdapter getAdapter(Context context, ForcastData qualityIndexData) {
        ArrayList<Integer> list = new ArrayList<>();
      /*  list.add(new HorizonBarChartItem(generateDataBar(qualityIndexData.getMachineIndex()), context, "质量年度指标", "指标", "包装机号", getHorizonBarChartLabels(qualityIndexData.getMachineIndex())));
        // 30 items
        List<QualityIndexData.MonthlyIndexPerMachineBean> monthlyIndexPerMachineBeanList = qualityIndexData.getMonthlyIndexPerMachine();
        for (int i = 0; i < monthlyIndexPerMachineBeanList.size(); i++) {
            List<QualityIndexData.MonthlyIndexPerMachineBean.IndexListBean> listBeanList = monthlyIndexPerMachineBeanList.get(i).getIndexList();
            list.add(new LineChartItem(generateDataLine(listBeanList), context, monthlyIndexPerMachineBeanList.get(i).getMachineName(), ResourceUtil.getString(R.string.x_label_month), ResourceUtil.getString(R.string.y_label_index), getLineChartLabels(listBeanList)));
        }*/
        return new ForcastAdapter(AppApplication.getAppContext(), list);
    }
}
