/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.macojia.leanproduct.db;


import com.macojia.leanproduct.R;
import com.macojia.leanproduct.AppApplication;
import com.macojia.leanproduct.bean.ItemApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlItemTableManager {

    /**
     * 加载管控条目
     *
     * @return
     */
    public static List<ItemApp> loadControlItemTable() {
        List<String> itemNames = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.control_item_names));
        List<Integer> itemImages = new ArrayList<Integer>();
        itemImages.add(R.mipmap.control_item_0);
        itemImages.add(R.mipmap.control_item_1);
        itemImages.add(R.mipmap.control_item_2);
        itemImages.add(R.mipmap.control_item_3);
        itemImages.add(R.mipmap.control_item_4);
        itemImages.add(R.mipmap.control_item_5);
        itemImages.add(R.mipmap.control_item_6);
        itemImages.add(R.mipmap.control_item_7);
        ArrayList<ItemApp> ControlItemTables = new ArrayList<>();
        for (int i = 0; i < itemNames.size(); i++) {
            ItemApp entity = new ItemApp(itemNames.get(i), itemImages.get(i));
            ControlItemTables.add(entity);
        }
        return ControlItemTables;
    }

}
