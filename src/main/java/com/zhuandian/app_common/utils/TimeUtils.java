package com.zhuandian.app_common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiedong
 * @DESC
 * @date 2020/5/26.
 */
public class TimeUtils {

    public static String getTimeFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(new Date());
//        System.out.println("格式化后的日期：" + dateNowStr);
        return dateNowStr;
    }
}
