package com.macojia.leanproduct.ui.control.adapter;

import java.util.HashMap;
import java.util.Map;

public class ProductBrandConstants {
    public static Map<String, String> Brand_NJ = new HashMap<String, String>();
    public static Map<String, String> Brand_TS = new HashMap<String, String>();
    public static Map<String, String> Brand_BS = new HashMap<String, String>();

    public void InitMap() {
        Brand_NJ.put("YF", "2015");
        Brand_NJ.put("YG", "2016");
        Brand_NJ.put("YH", "2017");
        Brand_NJ.put("YI", "2018");
        Brand_NJ.put("YJ", "2019");
        Brand_NJ.put("YK", "2020");
        Brand_NJ.put("YL", "2021");
        Brand_NJ.put("YM", "2022");
        Brand_NJ.put("YN", "2023");
        Brand_NJ.put("YO", "2024");
        Brand_NJ.put("MA", "01");
        Brand_NJ.put("MB", "02");
        Brand_NJ.put("MC", "03");
        Brand_NJ.put("MD", "04");
        Brand_NJ.put("ME", "05");
        Brand_NJ.put("MF", "06");
        Brand_NJ.put("MG", "07");
        Brand_NJ.put("MH", "08");
        Brand_NJ.put("MI", "09");
        Brand_NJ.put("MJ", "10");
        Brand_NJ.put("MK", "11");
        Brand_NJ.put("ML", "12");
        Brand_NJ.put("C1", "甲班");
        Brand_NJ.put("C2", "乙班");
        Brand_NJ.put("C3", "丙班");
        Brand_NJ.put("C4", "丁班");
        Brand_TS.put("Y5", "2015");
        Brand_TS.put("Y6", "2016");
        Brand_TS.put("Y7", "2017");
        Brand_TS.put("Y8", "2018");
        Brand_TS.put("Y9", "2019");
        Brand_TS.put("YA", "2020");
        Brand_TS.put("YB", "2021");
        Brand_TS.put("YC", "2022");
        Brand_TS.put("YD", "2023");
        Brand_TS.put("YE", "2024");
        Brand_TS.put("M1", "01");
        Brand_TS.put("M2", "02");
        Brand_TS.put("M3", "03");
        Brand_TS.put("M4", "04");
        Brand_TS.put("M5", "05");
        Brand_TS.put("M6", "06");
        Brand_TS.put("M7", "07");
        Brand_TS.put("M8", "08");
        Brand_TS.put("M9", "09");
        Brand_TS.put("MA", "10");
        Brand_TS.put("MB", "11");
        Brand_TS.put("MC", "12");
        Brand_TS.put("C5", "甲班");
        Brand_TS.put("C6", "乙班");
        Brand_TS.put("C7", "丙班");
        Brand_TS.put("C8", "丁班");
        Brand_BS.put("C1", "甲班");
        Brand_BS.put("C2", "乙班");
        Brand_BS.put("C3", "丙班");
        Brand_BS.put("C4", "丁班");
        Brand_NJ.put("MAA", "01");
        Brand_NJ.put("MAB", "02");
        Brand_NJ.put("MAC", "03");
        Brand_NJ.put("MAD", "04");
        Brand_TS.put("MA5", "13");
        Brand_TS.put("MA6", "06");
        Brand_TS.put("MA7", "07");
        Brand_TS.put("MA8", "08");
        Brand_TS.put("MA3", "11");
        Brand_TS.put("MA4", "12");
        Brand_TS.put("MA9", "15");
        Brand_TS.put("MAA", "16");
        Brand_TS.put("MAB", "17");
        Brand_TS.put("MAC", "18");
        Brand_TS.put("MAD", "19");
        Brand_BS.put("MAV5", "05");
        Brand_BS.put("MAV6", "06");
        Brand_BS.put("MAV7", "07");
        Brand_BS.put("MAV8", "08");
        Brand_BS.put("MAV9", "09");

    }

    public Map<String, String> getNameMap(int brandLen) {
        InitMap();
        if (brandLen == 6) {
            return Brand_NJ;
        } else if (brandLen == 7) {
            return Brand_TS;
        } else if (brandLen == 8) {
            return Brand_BS;
        } else {
            return null;
        }

    }
}
