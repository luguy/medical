package com.alibaba.medical.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author luguy
 * @date 2019/7/13 - 22:04
 */
public class DataUtil {


    /*返回当前日期与string类型日期之间相差的天数*/
    /**
     * create by: luguy
     * description: TODO
     * create time: 2019/7/14 11:29
     * @params  * @Param: date
     * @return int
     */
    public static int daysBetween(String date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        long time1 = 0;
        long time2 = 0;
        try{
            cal.setTime(sdf.parse(date));//有效时期
            time1 = cal.getTimeInMillis();
            cal.setTime(new Date());//当前日期
            time2 = cal.getTimeInMillis();
        }catch(Exception e){
            e.printStackTrace();
        }
        long between_days=(time1-time2)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

}
